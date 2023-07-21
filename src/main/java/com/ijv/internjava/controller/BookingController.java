package com.ijv.internjava.controller;

import com.ijv.internjava.model.dto.BookingDto;
import com.ijv.internjava.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor= @__(@Autowired))
@RequestMapping("/booking")
public class BookingController {
    private BookingService bookingService;

    @GetMapping
    public List<BookingDto> findAll(
            @RequestParam (required = false) String search,
            @RequestParam (required = false) String filter
    ) {
        return bookingService.findAll(search, filter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> detail(
            @PathVariable(name = "id") Long id
    ) {
        BookingDto bookingDtoResponse = bookingService.detail(id);
        return ResponseEntity.ok().body(bookingDtoResponse);
    }

    @PostMapping
    public ResponseEntity<BookingDto> create(
            @RequestBody BookingDto bookingDtoRequest
    ) {
        BookingDto bookingDtoResponse = bookingService.create(bookingDtoRequest);
        return new ResponseEntity<>(bookingDtoResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<BookingDto> edit(
            @RequestBody BookingDto bookingDtoRequest
    ) {
        BookingDto bookingDtoResponse = bookingService.edit(bookingDtoRequest);
        return ResponseEntity.ok().body(bookingDtoResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable(name = "id") Long id
    ) {
        bookingService.delete(id);
    }

}
