package com.service;

import com.entity.Ticket;
import com.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    // Fetch all tickets
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Create a new ticket
    public Ticket createTicket(Ticket ticket) {
        ticket.setCreatedDate(new Date()); 
        return ticketRepository.save(ticket);
    }

    // Update an existing ticket
    public Ticket updateTicket(Long id, Ticket ticketDetails) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setTitle(ticketDetails.getTitle());
            ticket.setDescription(ticketDetails.getDescription());
            ticket.setPriority(ticketDetails.getPriority());
            ticket.setStatus(ticketDetails.getStatus());
            ticket.setModifiedDate(new Date());
            return ticketRepository.save(ticket);
        }
        throw new RuntimeException("Ticket not found with id: " + id);
    }

    // Delete a ticket by ID
    public void deleteTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
        } else {
            throw new RuntimeException("Ticket not found with id: " + id);
        }
    }
}
