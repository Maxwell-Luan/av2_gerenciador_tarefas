package com.arquiteturaWeb.provaAv2.service;

import com.arquiteturaWeb.provaAv2.model.Task;
import com.arquiteturaWeb.provaAv2.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepository.findAllByUserId(userId);
    }

    public void deleteTaskById(Long id) {
        taskRepository.deleteById(id);
    }
}
