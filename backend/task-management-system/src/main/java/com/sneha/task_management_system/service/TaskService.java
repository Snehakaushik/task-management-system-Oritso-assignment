package com.sneha.task_management_system.service;

import com.sneha.task_management_system.model.Task;
import com.sneha.task_management_system.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository repo;
    public TaskService(TaskRepository repo){
        this.repo = repo;
    }

    public Task createTask(Task task) {
        return repo.save(task);
    }

    public List<Task> getAllTasks() {
        return repo.findAll();
    }


    public Task updateTask(Long id, Task task) {

        Task existingTask = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        existingTask.setTaskTitle(task.getTaskTitle());
        existingTask.setTaskDescription(task.getTaskDescription());
        existingTask.setTaskDueDate(task.getTaskDueDate());
        existingTask.setTaskStatus(task.getTaskStatus());
        existingTask.setTaskRemarks(task.getTaskRemarks());
        existingTask.setLastUpdatedBy(task.getLastUpdatedBy());

        return repo.save(existingTask);
    }

    public void deleteTask(Long id) {
         repo.deleteById(id);
    }

    public List<Task> searchTasks(String keyword) {
        return repo.searchTasks(keyword);
    }
}
