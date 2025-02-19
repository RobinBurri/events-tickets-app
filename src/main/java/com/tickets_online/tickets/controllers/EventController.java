package com.tickets_online.tickets.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tickets_online.tickets.models.Event;
import com.tickets_online.tickets.models.Organizer;
import com.tickets_online.tickets.models.Product;
import com.tickets_online.tickets.repositories.EventRepository;
import com.tickets_online.tickets.repositories.OrganizerRepository;
import com.tickets_online.tickets.repositories.ProductRepository;

@RestController
public class EventController {

    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(OrganizerRepository organizerRepository, EventRepository eventRepository,
            ProductRepository productRepository) {
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/organizers")
    public List<Organizer> getOrganizers() {
        System.out.println("HHĦ");
        return organizerRepository.findAll();
    }

    @GetMapping("/events")
    public List<Event> getEventsByOrganizerId(@RequestParam("organizerId") int organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    @GetMapping("/events/{id}")
    public Event getEventsById(@PathVariable("id") int id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Event with Id: " + id + " not found"));
    }

    @GetMapping("/products")
    public List<Product> getProductsByEvent(@RequestParam("eventId") int id) {
        return productRepository.findByEventId(id);
    }

}
