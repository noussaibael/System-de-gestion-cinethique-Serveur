package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class CD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean available;

    // Constructeurs, getters et setters
    public CD() {}

    public CD(String title, boolean available) {
        this.title = title;
        this.available = available;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) { this.title = title; }
    public void setAvailable(boolean available) { this.available = available; }
}
