package com.example.study_planner;

import jakarta.persistence.*;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Duration;


@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDate dueDate;

    // Ensure ALL getters/setters are present and public
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
    
    

    // ✅ Add this method — no controller change!
    public String getTimeRemaining() {
        if (dueDate == null) return "No due date";
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dueDateTime = LocalDateTime.of(dueDate, LocalTime.of(23, 59, 59));
        Duration duration = Duration.between(now, dueDateTime);

        if (duration.isNegative()) return "Overdue";
        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;

        if (days > 0)
            return days + "d " + hours + "h left";
        else if (hours > 0)
            return hours + "h " + minutes + "m left";
        else if (minutes > 0)
            return minutes + "m left";
        else
            return "Due soon!";
    }
    
}
