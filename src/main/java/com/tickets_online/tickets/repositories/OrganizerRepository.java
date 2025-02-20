package com.tickets_online.tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickets_online.tickets.models.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {

}
