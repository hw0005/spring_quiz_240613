package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;
import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.respository.CompanyRepository;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;
	
	// 펜션 예약 조회 리스트
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	// 펜션 삭제버튼
	public int deleteBookingById(String id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	// add
	public void addBooking(String name, LocalDate date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// 조회
	// input: name, phoneNumber
	// output: Booking(최신) or null
	
	public Booking getLatestBookingByNamePhoneNumber(String name, String phoneNumber) {
		// 리스트가 없을 때: []    있을 때: [booking1, booking2...]
		List<Booking> bookingList = bookingMapper.selectBookingListByNamePhoneNumber(name, phoneNumber);
//		if (bookingList.isEmpty()) {
//			return null;
//		}
		
		return bookingList.isEmpty() ? null : bookingList.get(bookingList.size() - 1);
		
	}
	
}
