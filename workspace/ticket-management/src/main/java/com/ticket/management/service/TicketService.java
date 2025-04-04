package com.ticket.management.service;

import com.ticket.management.dto.TicketDTO;
import com.ticket.management.entity.TicketPriority;
import com.ticket.management.entity.TicketStatus;
import com.ticket.management.entity.User;
import com.ticket.management.entity.UserTicket;
import com.ticket.management.repository.TicketPriorityRepository;
import com.ticket.management.repository.TicketRepository;
import com.ticket.management.repository.TicketStatusRepository;
import com.ticket.management.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TicketPriorityRepository ticketPriorityRepository;
	@Autowired
	TicketStatusRepository ticketStatusRepository;
	@Autowired
    private UserRepository userRepository;
	
	
    public List<UserTicket> getTickets(Long UserId) {
	    List<UserTicket> ticketDetails = null;
 
    if (UserId == 1) {
        ticketDetails = ticketRepository.findAll();
    } else {
        User user = new User();
        user.setId(UserId);
        ticketDetails = ticketRepository.findByCreatedByOrAssignedToAndIsDeletedFalse(user, user);
    }
    return ticketDetails;
 	}
    
    public List<TicketPriority> getPriorities(){
		return ticketPriorityRepository.findAll();
	}
    public List<UserTicket> getTickets(){
		return ticketRepository.findAll();
	}
    
    public List<TicketStatus> getStatus(){
		return ticketStatusRepository.findAll();
	}
    
    public void createTicket(TicketDTO ticketDTO) {
	    if (ticketDTO == null || ticketDTO.getCreatedBy() == null || ticketDTO.getAssignedTo() == null) {
	        throw new IllegalArgumentException("Ticket creation failed due to missing required fields.");
	    }

	    TicketPriority priority = ticketPriorityRepository.findById(ticketDTO.getPriority())
	            .orElseThrow(() -> new RuntimeException("Priority not found"));

	    TicketStatus status = ticketStatusRepository.findById(ticketDTO.getStatus())
	            .orElseThrow(() -> new RuntimeException("Status not found"));

	    User createdBy = userRepository.findById(ticketDTO.getCreatedBy())
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    User assignedTo = userRepository.findById(ticketDTO.getAssignedTo())
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    UserTicket ticket = new UserTicket();
	    ticket.setTitle(ticketDTO.getTitle());
	    ticket.setDescription(ticketDTO.getDescription());
	    ticket.setPriority(priority);
	    ticket.setStatus(status);
	    ticket.setCreatedBy(createdBy);
	    ticket.setAssignedTo(assignedTo);
	    ticket.setTicketComment(ticketDTO.getTicketComment());
	    ticket.setDeleted(false);
	    ticketRepository.save(ticket);
	}
    
    public UserTicket updateTicket(Long id, TicketDTO ticketDTO) {
        return ticketRepository.findById(id).map(ticket -> {
            TicketPriority priority = ticketPriorityRepository.findById(ticketDTO.getPriority())
                    .orElseThrow(() -> new RuntimeException("Priority not found"));

            TicketStatus status = ticketStatusRepository.findById(ticketDTO.getStatus())
                    .orElseThrow(() -> new RuntimeException("Status not found"));

            User createdBy = userRepository.findById(ticketDTO.getCreatedBy())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            User assignedTo = userRepository.findById(ticketDTO.getAssignedTo())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            ticket.setTitle(ticketDTO.getTitle());
            ticket.setDescription(ticketDTO.getDescription());
            ticket.setPriority(priority);
            ticket.setStatus(status);
            ticket.setCreatedBy(createdBy);
            ticket.setAssignedTo(assignedTo);
            ticket.setTicketComment(ticketDTO.getTicketComment());
            ticket.setModifiedDate(LocalDateTime.now());
            ticket.setDeleted(false);
            ticket.setDeleted(ticketDTO.isDeleted());

            if (ticketDTO.isDeleted()) {
                ticket.setDeleteDate(LocalDateTime.now());
            } else {
                ticket.setDeleteDate(null);
            }

            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + id));
    }
    
    public UserTicket deleteTicket(Long UserId, TicketDTO ticketDTO) {
        return ticketRepository.findById(UserId).map(ticket -> {
            ticket.setDeleted(true);
            ticket.setDeleteDate(LocalDateTime.now());
            ticket.setModifiedDate(LocalDateTime.now());

            return ticketRepository.save(ticket);
        }).orElseThrow(() -> new RuntimeException("Ticket not found with ID: " + UserId));
    }  
}
