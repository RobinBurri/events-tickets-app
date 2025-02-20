package com.tickets_online.tickets.controllers;

import java.util.NoSuchElementException;

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
        return this.registrationRepository.create(registration);
    }

    @GetMapping("/{ticketCode}")
    public Registration findRegistrationByTicketCode(@PathVariable String ticktetCode) {
        return registrationRepository.findByTicketCode(ticktetCode).orElseThrow(
                () -> new NoSuchElementException("Registration with ticket code: " + ticktetCode + " not found."));
    }

    @PutMapping
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationRepository.update(registration);
    }

    @DeleteMapping("/{ticketCode}")
    public void deleteByTicketCode(@PathVariable String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }

}
