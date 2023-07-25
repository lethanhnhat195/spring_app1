package com.ijv.internjava.service.impl;

import com.google.common.base.Joiner;
import com.ijv.internjava.mapper.BookingMapper;
import com.ijv.internjava.model.dto.BookingDetailDto;
import com.ijv.internjava.model.dto.BookingDto;
import com.ijv.internjava.model.entity.Booking;
import com.ijv.internjava.model.entity.BookingDetail;
import com.ijv.internjava.repository.BookingDetailRepository;
import com.ijv.internjava.repository.BookingRepository;
import com.ijv.internjava.repository.CustomerRepository;
import com.ijv.internjava.repository.ServiceRepository;
import com.ijv.internjava.service.BookingService;
import com.ijv.internjava.specification.BookingSpecificationsBuilder;
import com.ijv.internjava.utils.SearchOperation;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private BookingDetailRepository bookingDetailRepository;
    private ServiceRepository serviceRepository;
    private CustomerRepository customerRepository;
    @Override
    public List<BookingDto> findAll(String search, String filter) {
        if (search != null) {
            return bookingRepository.search(search).stream()
                    .map(booking -> BookingMapper.getInstance().toDto(booking))
                    .collect(Collectors.toList());
        } else if (filter != null) {
            BookingSpecificationsBuilder builder = new BookingSpecificationsBuilder();
            String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
            Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
            Matcher matcher = pattern.matcher(filter + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
            }
            Specification<Booking> spec = builder.build();
            return bookingRepository.findAll(spec).stream()
                    .map(booking -> BookingMapper.getInstance().toDto(booking))
                    .collect(Collectors.toList());
        } else {
            return bookingRepository.findAll().stream()
                    .map(booking -> BookingMapper.getInstance().toDto(booking))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public BookingDto detail(Long id) {
        Booking booking = bookingRepository.findById(id).get();
        return BookingMapper.getInstance().toDto(booking);
    }

    @Override
    public BookingDto create(BookingDto bookingDto) {
        Booking newBooking = new Booking();
        newBooking.setCustomer(customerRepository.findById(bookingDto.getCustomerId())
                .orElseThrow(()-> new EntityNotFoundException(String.format("Booking with id [%d] was not found!", bookingDto.getCustomerId()))));
        newBooking.setPhoneNumber(bookingDto.getPhoneNumber());
        newBooking.setBookingDate(bookingDto.getBookingDate());
        newBooking.setFromTime(bookingDto.getFromTime());
        newBooking.setToTime(bookingDto.getToTime());
        newBooking.setNote(bookingDto.getNote());
        newBooking.setStatus(bookingDto.getStatus());
        Set<BookingDetail> bookingDetails = new HashSet<>();
        bookingRepository.save(newBooking);
        for (BookingDetailDto bookingDetailDto : bookingDto.getBookingDetailDtos()) {
            BookingDetail newBookingDetail = new BookingDetail();
            newBookingDetail.setBooking(newBooking);
            newBookingDetail.setService(serviceRepository.findById(bookingDetailDto.getServiceId())
                    .orElseThrow(()-> new EntityNotFoundException(String.format("Service with id [%d] was not found!", bookingDetailDto.getServiceId()))));
            newBookingDetail.setNote(bookingDetailDto.getNote());
            bookingDetails.add(newBookingDetail);
            bookingDetailRepository.save(newBookingDetail);
        }
        newBooking.setBookingDetails(bookingDetails);
        return BookingMapper.getInstance().toDto(bookingRepository.save(newBooking));
    }

    @Override
    public BookingDto edit(BookingDto bookingDto) {
        Booking booking = bookingRepository.findById(bookingDto.getId())
                .orElseThrow(()-> new EntityNotFoundException(String.format("Booking with id [%d] was not found!", bookingDto.getCustomerId())));
        booking.setId(bookingDto.getId());
        booking.setCustomer(customerRepository.findById(bookingDto.getCustomerId())
                .orElseThrow(()-> new EntityNotFoundException(String.format("Customer with id [%d] was not found!", bookingDto.getCustomerId()))));
        booking.setPhoneNumber(bookingDto.getPhoneNumber());
        booking.setBookingDate(bookingDto.getBookingDate());
        booking.setFromTime(bookingDto.getFromTime());
        booking.setToTime(bookingDto.getToTime());
        booking.setNote(bookingDto.getNote());
        booking.setStatus(bookingDto.getStatus());
        for (BookingDetailDto bookingDetailDto : bookingDto.getBookingDetailDtos()) {
            BookingDetail bookingDetail = bookingDetailRepository.findById(bookingDetailDto.getId())
                    .orElseThrow(()-> new EntityNotFoundException(String.format("Booking Detail with id [%d] was not found!", bookingDetailDto.getId())));
            bookingDetail.setBooking(booking);
            bookingDetail.setService(serviceRepository.findById(bookingDetail.getId())
                    .orElseThrow(()-> new EntityNotFoundException(String.format("Service with id [%d] was not found!", bookingDetailDto.getId()))));
            bookingDetail.setNote(bookingDetailDto.getNote());
            bookingDetailRepository.save(bookingDetail);
        }
        return BookingMapper.getInstance().toDto(bookingRepository.save(booking));
    }

    @Override
    public void delete(long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("Booking with id [%d] was not found!", id)));
        for (BookingDetail bookingDetail : booking.getBookingDetails()) {
            bookingDetailRepository.deleteById(bookingDetail.getId());
        }
        bookingRepository.delete(booking);
    }
}