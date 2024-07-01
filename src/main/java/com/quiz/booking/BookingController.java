package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	// 펜션 예약 목록 페이지
	// http://localhost:8080/booking/booking-list-view
	// select(조회)
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model){
		
		// db select
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// 삭제 AJAX한테 요청 - id로 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") String id) {
		
		// db delete
		int rowCount = bookingBO.deleteBookingById(id);
		
		// 응답값 json
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		}	else {
			result.put("code", 500);
			result.put("error_messgae", "에러의 원인");
		}
		
		return result;
	}
	
	// 펜션 예약하는 페이지
	// http://localhost:8080/booking/make-booking-view
	// AJAX한테 추가요청(ResponseBody) -> insert(따로 만들기)
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// AJAX 요청 - add 예약
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBookingList(
			@RequestParam("name") String name,
			@RequestParam("date") LocalDate date, // String도 된다.
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			) {
		
		// db insert
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result;
	}
	
	
	// 펜션 예약확인하는 페이지
	// http://localhost:8080/booking/check-booking-view
	
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		
		return "booking/checkBooking";
	}
	
	// 펜션 예약 조회
	// AJAX한테 조회요청(ResponseBody) -> select(따로 만들기)
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		// db select
		boolean isBooking = bookingBO.getBooking(name, phoneNumber);
		
		// 응답값 json
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		
		return result;
		
	}
	
	
}
