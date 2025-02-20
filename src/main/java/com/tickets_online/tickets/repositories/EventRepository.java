package com.tickets_online.tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickets_online.tickets.models.Event;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOrganizerId(int organizerId);
}
