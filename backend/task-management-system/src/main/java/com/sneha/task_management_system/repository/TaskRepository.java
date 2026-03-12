package com.sneha.task_management_system.repository;

import com.sneha.task_management_system.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE " +
            "LOWER(t.taskTitle) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.taskDescription) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.taskStatus) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.taskRemarks) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.createdBy) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.lastUpdatedBy) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Task> searchTasks(String keyword);
}
