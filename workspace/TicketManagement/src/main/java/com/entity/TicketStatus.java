package com.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_statuses")
public class TicketStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true, nullable = false)
    private String name;

    @Column(length = 200)
    private String description;

    // Constructors
    public TicketStatus() {
    }

    public TicketStatus(String name) {
        this.name = name;
    }

    public TicketStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // For debugging/logging
    @Override
    public String toString() {
        return "TicketStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
