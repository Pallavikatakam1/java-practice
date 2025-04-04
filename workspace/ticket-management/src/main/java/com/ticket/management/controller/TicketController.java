package com.ticket.management.controller;

import com.ticket.management.dto.TicketDTO;
import com.ticket.management.entity.TicketPriority;
import com.ticket.management.entity.TicketStatus;
import com.ticket.management.entity.UserTicket;
import com.ticket.management.repository.TicketPriorityRepository;
import com.ticket.management.repository.TicketRepository;
import com.ticket.management.repository.TicketStatusRepository;
import com.ticket.management.repository.UserRepository;
import com.ticket.management.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
public class TicketController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TicketPriorityRepository ticketPriorityRepository;
	
	@Autowired
	TicketStatusRepository ticketStatusRepository;
	
	@Autowired
	TicketService ticketService;
	
    @PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createTicket(@RequestBody TicketDTO ticketDTO) {
	    if (ticketDTO == null) {
	        throw new IllegalArgumentException("TicketDTO cannot be null");
	    }
	    ticketService.createTicket(ticketDTO);
	}

    @GetMapping("/all")
    public List<UserTicket> getTickets(@PathVariable Long id){
		return ticketService.getTickets(id);
	}
    @GetMapping("/tickets")
    public List<UserTicket>getTickets() {
		return ticketService.getTickets();
	}
    
    @GetMapping("/ticketPriority")
	public List<TicketPriority> getPriorities(){
		return ticketService.getPriorities();
	}
	
    @GetMapping("/ticketStatus")
	public List<TicketStatus> getStatus(){
		return ticketService.getStatus();
	}
    
    @PutMapping("/tickets/update/{id}")
	public UserTicket updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
	    if (id == null || ticketDTO == null) {
	        throw new IllegalArgumentException("ID or TicketDTO cannot be null");
	    }
	    return ticketService.updateTicket(id, ticketDTO);
	}
    
    @PutMapping("/tickets/delete/{id}")
	public UserTicket removeTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
	    return ticketService.deleteTicket(id, ticketDTO);
	}
	
}


    








