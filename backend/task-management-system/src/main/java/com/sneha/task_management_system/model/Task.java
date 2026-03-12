package com.sneha.task_management_system.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_title", nullable = false)
    private String taskTitle;

    @Column(name = "task_description", columnDefinition = "TEXT")
    private String taskDescription;

    @Column(name = "task_due_date")
    private LocalDate taskDueDate;

    @Column(name = "task_status")
    private String taskStatus;

    @Column(name = "task_remarks")
    private String taskRemarks;

    @Column(name = "created_on", updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "last_updated_on")
    private LocalDateTime lastUpdatedOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_updated_by")
    private String lastUpdatedBy;

    @PrePersist
    public void onCreate(){
        this.createdOn = LocalDateTime.now();
        this.lastUpdatedOn = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        this.lastUpdatedOn = LocalDateTime.now();
    }
}
