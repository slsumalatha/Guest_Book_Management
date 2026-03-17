package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "guestbook")
public class GuestBook {
    
    @Id
    private Long id;

    private String customerName;
    private String message;
    private LocalDateTime date;
    private String status;   // PENDING, APPROVED, REJECTED
    private String reply;

    // Automatically set date & default status before saving
    @PrePersist
    public void prePersist() {
        date = LocalDateTime.now();
        status = "PENDING";
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }
}
