package com.ticket.management.repository;

import com.ticket.management.entity.User;
import com.ticket.management.entity.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<UserTicket, Long> {

	List<UserTicket> findByCreatedByOrAssignedToAndIsDeletedFalse(User user, User user1);
	
}

