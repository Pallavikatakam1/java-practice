package com.ticket.management.repository;

import com.ticket.management.entity.TicketPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPriorityRepository extends JpaRepository<TicketPriority, Long> {
}
