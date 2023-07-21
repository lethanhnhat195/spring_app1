package com.ijv.internjava.mapper;

import com.ijv.internjava.model.dto.BookingDto;
import com.ijv.internjava.model.entity.Booking;

import java.util.stream.Collectors;

public class BookingMapper {
    private static BookingMapper INSTANCE;

    public static BookingMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new BookingMapper();
        }
        return INSTANCE;
    }

    public Booking toEntity(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(bookingDto.getId());
        booking.setPhoneNumber(bookingDto.getPhoneNumber());
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setFromTime(bookingDto.getFromTime());
        booking.setToTime(bookingDto.getToTime());
        booking.setNote(bookingDto.getNote());
        booking.setStatus(bookingDto.getStatus());
        booking.setBookingDetails(bookingDto.getBookingDetailDtos().stream()
                .map(bookingDetailDto -> BookingDetailMapper.getInstance().toEntity(bookingDetailDto))
                .collect(Collectors.toSet()));
        return booking;
    }

    public BookingDto toDto(Booking booking) {
        BookingDto bookingDto = new BookingDto();
        bookingDto.setId(booking.getId());
        bookingDto.setCustomerId(booking.getCustomer().getId());
        bookingDto.setPhoneNumber(booking.getPhoneNumber());
        bookingDto.setBookingDate(booking.getBookingDate());
        bookingDto.setFromTime(booking.getFromTime());
        bookingDto.setToTime(booking.getToTime());
        bookingDto.setNote(booking.getNote());
        bookingDto.setStatus(booking.getStatus());
        bookingDto.setBookingDetailDtos(booking.getBookingDetails().stream()
                .map(bookingDetail -> BookingDetailMapper.getInstance().toDto(bookingDetail))
                .collect(Collectors.toSet()));
        return bookingDto;
    }
}
