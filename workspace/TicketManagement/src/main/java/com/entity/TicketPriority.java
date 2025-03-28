package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket_priorities")
public class TicketPriority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, unique = true, nullable = false)
    private String name;

    @Column(length = 200)
    private String description;

    // Constructors
    public TicketPriority() {
    }

    public TicketPriority(String name) {
        this.name = name;
    }

    public TicketPriority(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters and setters
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
        return "TicketPriority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
