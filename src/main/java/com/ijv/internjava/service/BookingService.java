package com.ijv.internjava.service;

import com.ijv.internjava.model.dto.BookingDto;

import java.util.List;

public interface BookingService {
    List<BookingDto> findAll(String search, String filter);
    BookingDto detail(Long id);
    BookingDto create(BookingDto bookingDto);
    BookingDto edit(BookingDto bookingDto);
    void delete(long id);
}
