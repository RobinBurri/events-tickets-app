package com.tickets_online.tickets.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tickets_online.tickets.models.Registration;

@Repository
public interface RegistrationRepository extends MongoRepository<Registration, String> {

    Optional<Registration> findByTicketCode(String ticketCode);
   
    void deleteByTicketCode(String ticketCode);
}
