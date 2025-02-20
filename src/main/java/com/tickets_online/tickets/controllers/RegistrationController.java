package com.tickets_online.tickets.controllers;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tickets_online.tickets.models.Registration;
import com.tickets_online.tickets.repositories.RegistrationRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody @Valid Registration registration) {
        String ticketCode = UUID.randomUUID().toString();

        return this.registrationRepository
                .save(new Registration(null, registration.productId(), ticketCode, registration.attendeeName()));
    }

    @GetMapping("/{ticketCode}")
    public Registration findRegistrationByTicketCode(@PathVariable String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode).orElseThrow(
                () -> new NoSuchElementException("Registration with ticket code: " + ticketCode + " not found."));
    }

    @PutMapping
    public Registration updateRegistration(@RequestBody Registration registration) {
        String ticketCode = registration.ticketCode();

        var existing = registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException(
                        "Registration with ticket code: " + ticketCode + " not found."));
        // only update the name of the attendee
        return registrationRepository
                .save(new Registration(existing.id(), existing.productId(), ticketCode, registration.attendeeName()));
    }

    @DeleteMapping("/{ticketCode}")
    public void deleteByTicketCode(@PathVariable String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }

}
