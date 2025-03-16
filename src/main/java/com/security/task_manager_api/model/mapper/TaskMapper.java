package com.security.task_manager_api.model.mapper;

import com.security.task_manager_api.model.DTO.TaskDto;
import com.security.task_manager_api.model.Entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring" )
public interface TaskMapper {

    TaskEntity taskDtoToTaskEntity(TaskDto createTaskDto);
    TaskDto taskEntityToTaskDto(TaskEntity taskEntity);
    void updateTaskEntityFromDto(TaskDto taskDto, @MappingTarget TaskEntity taskEntity);

}
