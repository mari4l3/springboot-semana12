package com.example.ticketapi.service;

import com.example.ticketapi.entity.Ticket;
import com.example.ticketapi.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    // Crear un ticket
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Obtener todos los tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
    // Obtener un ticket por ID
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    // Actualizar un ticket
    public Ticket updateTicket(Long id, Ticket ticket) {
        Ticket ticketToUpdate = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
        ticketToUpdate.setTitulo(ticket.getTitulo());
        ticketToUpdate.setDescripcion(ticket.getDescripcion());
        ticketToUpdate.setPrioridad(ticket.getPrioridad());
        return ticketRepository.save(ticketToUpdate);
    }

    // Eliminar un ticket
    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));
        ticketRepository.delete(ticket);
    }
}

    