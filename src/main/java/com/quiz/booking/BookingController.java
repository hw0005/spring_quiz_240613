package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	// 펜션 예약 목록 페이지
	// http://localhost:8080/booking/booking-list-view
	// AJAX한테 삭제요청(ResponseBody) -> 지금은 select(조회), delete(따로 만들기)
	@GetMapping("/booking-list-view")
	public List<Booking> bookingListView(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("state") String state,
			Model model){
		
		bookingBO.getBookingList()
		
		return "booking/bookingList";
	}
	
	// 펜션 예약하는 페이지
	// http://localhost:8080/booking/make-booking-view
	// AJAX한테 추가요청(ResponseBody) -> insert(따로 만들기)
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		
		
		return "booking/makeBooking";
	}
	
	// 펜션 예약확인하는 페이지
	// http://localhost:8080/booking/check-booking-view
	// AJAX한테 조회요청(ResponseBody) ->select(따로 만들기)
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		
		return "booking/checkBooking";
	}
	
}
