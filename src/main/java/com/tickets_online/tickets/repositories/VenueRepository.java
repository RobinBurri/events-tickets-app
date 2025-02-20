package com.tickets_online.tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickets_online.tickets.models.Venue;

public interface VenueRepository extends JpaRepository<Venue, Integer> {}
