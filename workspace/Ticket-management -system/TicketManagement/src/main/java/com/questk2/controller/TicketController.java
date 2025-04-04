package com.questk2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.questk2.dto.TicketDTO;
import com.questk2.entity.Ticket;
import com.questk2.entity.TicketPriority;
import com.questk2.entity.TicketStatus;
import com.questk2.repository.TicketPriorityRepository;
import com.questk2.repository.TicketRepository;
import com.questk2.repository.TicketStatusRepository;
import com.questk2.repository.UserRepository;
import com.questk2.service.TicketOperationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@Tag(name = "Ticket Controller", description = "APIs for managing tickets, priorities, statuses")
public class TicketController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private TicketPriorityRepository ticketPriorityRepository;
	@Autowired
	private TicketStatusRepository ticketStatusRepository;
	@Autowired
	private TicketOperationService ticketOperationService;

	/**
	 * Get all tickets for a given user ID.
	 */
	@Operation(summary = "Get all tickets", description = "Fetch all tickets for the given user ID")
	@ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = Ticket.class)))
	@ApiResponse(responseCode = "500", description = "Internal server error")
	@GetMapping("/tickets/{id}")
	public List<Ticket> getTickets(@PathVariable Long id) {
		return ticketOperationService.getAllTickets(id);
	}

	/**
	 * Get all ticket priorities.
	 */
	@Operation(summary = "Get ticket priorities", description = "Fetch all available ticket priorities")
	@ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = TicketPriority.class)))
	@GetMapping("/ticketPriority")
	public List<TicketPriority> getPriorities() {
		return ticketOperationService.getAllPriorities();
	}

	/**
	 * Get all ticket statuses.
	 */
	@Operation(summary = "Get ticket statuses", description = "Fetch all available ticket statuses")
	@ApiResponse(responseCode = "200", description = "Success", content = @Content(schema = @Schema(implementation = TicketStatus.class)))
	@GetMapping("/ticketStatus")
	public List<TicketStatus> getStatus() {
		return ticketOperationService.getAllStatus();
	}

	/**
	 * Create a new ticket.
	 */
	@Operation(summary = "Create ticket", description = "Add a new ticket to the system")
	@ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = String.class)))
	@PostMapping("/tickets/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void createTicket(@RequestBody TicketDTO ticketDTO) {
		if (ticketDTO == null) {
			throw new IllegalArgumentException("TicketDTO cannot be null");
		}
		ticketOperationService.createTicket(ticketDTO);
	}

	/**
	 * Update an existing ticket by ID.
	 */
	@Operation(summary = "Update ticket", description = "Update an existing ticket by ID")
	@ApiResponse(responseCode = "200", description = "Updated", content = @Content(schema = @Schema(implementation = Ticket.class)))
	@PutMapping("/tickets/update/{id}")
	public Ticket updateTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
		if (id == null || ticketDTO == null) {
			throw new IllegalArgumentException("ID or TicketDTO cannot be null");
		}
		return ticketOperationService.updateTicket(id, ticketDTO);
	}

	/**
	 * Soft delete a ticket by ID (marks as deleted).
	 */
	@Operation(summary = "Delete ticket (soft)", description = "Soft delete a ticket by ID using a DTO")
	@ApiResponse(responseCode = "200", description = "Deleted", content = @Content(schema = @Schema(implementation = Ticket.class)))
	@PutMapping("/tickets/delete/{id}")
	public Ticket removeTicket(@PathVariable Long id, @RequestBody TicketDTO ticketDTO) {
		return ticketOperationService.deleteTicket(id, ticketDTO);
	}
}
