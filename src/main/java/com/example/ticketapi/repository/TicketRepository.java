package com.example.ticketapi.repository;

import com.example.ticketapi.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    boolean existsById(Long id);
}


