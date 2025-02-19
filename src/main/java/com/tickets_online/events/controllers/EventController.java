package com.tickets_online.events.controllers;

import org.springframework.stereotype.Controller;

import com.tickets_online.events.repositories.EventRepository;
import com.tickets_online.events.repositories.OrganizerRepository;
import com.tickets_online.events.repositories.ProductRepository;

@Controller
public class EventController {
    
    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;
}
