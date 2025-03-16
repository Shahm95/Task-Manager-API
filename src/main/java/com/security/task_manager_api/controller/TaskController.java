package com.security.task_manager_api.controller;

import com.security.task_manager_api.model.DTO.TaskDto;
import com.security.task_manager_api.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @GetMapping
   // @PreAuthorize("hasAnyRole()")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable(name = "id") Integer taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        return this.taskService.createTask(taskDto);
    }

    @PutMapping("/{id}")
    public TaskDto updateTask(@RequestBody TaskDto taskDto, @PathVariable(name = "id") Integer taskId) {
        return this.taskService.updateTask(taskDto,taskId);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable(name = "id")  Integer taskId) {
        this.taskService.deleteTask(taskId);
        return "Task deleted successfully";
    }

}
