package com.ijv.internjava.mapper;

import com.ijv.internjava.model.dto.BookingDetailDto;
import com.ijv.internjava.model.entity.BookingDetail;
import com.ijv.internjava.repository.ServiceRepository;

public class BookingDetailMapper {
    private static BookingDetailMapper INSTANCE;
    private ServiceRepository serviceRepository;

    public static BookingDetailMapper getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new BookingDetailMapper();
        }
        return INSTANCE;
    }

    public BookingDetail toEntity(BookingDetailDto bookingDetailDto) {
        BookingDetail bookingDetail = new BookingDetail();
        bookingDetail.setId(bookingDetailDto.getId());
        bookingDetail.setNote(bookingDetailDto.getNote());
        return bookingDetail;
    }

    public BookingDetailDto toDto(BookingDetail bookingDetail) {
        BookingDetailDto bookingDetailDto = new BookingDetailDto();
        bookingDetailDto.setId(bookingDetail.getId());
        bookingDetailDto.setServiceId(bookingDetail.getService().getId());
        bookingDetailDto.setNote(bookingDetail.getNote());
        return bookingDetailDto;
    }
}
