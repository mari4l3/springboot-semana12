package com.example.ticketapi.controller;


import com.example.ticketapi.entity.Ticket;
import com.example.ticketapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Crear un ticket
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    // Obtener todos los tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();

    }

    // Obtener un ticketnpor ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar un ticket
    @PutMapping("/{id}")
    public Ticket updateTicket(@PathVariable Long id, @RequestBody Ticket ticketDetails) {
        return ticketService.updateTicket(id, ticketDetails);
    }

    // Eliminar un ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}