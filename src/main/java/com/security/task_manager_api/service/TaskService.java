package com.security.task_manager_api.service;

import com.security.task_manager_api.model.DTO.TaskDto;
import com.security.task_manager_api.model.Entity.TaskEntity;
import com.security.task_manager_api.model.mapper.TaskMapper;
import com.security.task_manager_api.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public List<TaskDto> getAllTask(){
        return  this.taskRepository.findByDeletedAtIsNull().stream().map(taskMapper::taskEntityToTaskDto).collect(Collectors.toList());
    }

    public TaskDto getTaskById(Integer id){
        return this.taskRepository.findById(id).map(taskMapper::taskEntityToTaskDto).orElse(null);
    }

    public TaskDto createTask(TaskDto taskDto ){
         TaskEntity user = this.taskMapper.taskDtoToTaskEntity(taskDto);
         user.setCreatedAt(LocalDateTime.now());
         TaskEntity savedTask = this.taskRepository.save(user);
        return this.taskMapper.taskEntityToTaskDto(savedTask);
    }

    public TaskDto updateTask(TaskDto taskDto, Integer taskId){
        TaskEntity task = this.taskRepository.findByIdAndDeletedAtNull(taskId);
        task.setUpdatedAt(LocalDateTime.now());
        this.taskMapper.updateTaskEntityFromDto(taskDto, task);
        TaskEntity updatedTask = this.taskRepository.save(task);
        return this.taskMapper.taskEntityToTaskDto(updatedTask);

    }

    public void deleteTask(Integer taskId){
      Optional<TaskEntity> task =  this.taskRepository.findById(taskId);
      if(task.isPresent()){
          TaskEntity taskEntity = task.get();
          taskEntity.setDeletedAt(LocalDateTime.now());
          this.taskRepository.save(taskEntity);
          return;
      }
        throw new NoSuchElementException("Task not found with id: " + taskId);
    }


}