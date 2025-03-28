package com.controller;

import com.entity.Ticket;
import com.repository.TicketRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173") // Allows React to communicate with backend
@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Get all tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Create a new ticket
    @PostMapping
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    // Delete a ticket
    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Long id) {
        ticketRepository.deleteById(id);
    }
}
