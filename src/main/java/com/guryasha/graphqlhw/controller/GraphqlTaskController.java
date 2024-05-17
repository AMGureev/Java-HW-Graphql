package com.guryasha.graphqlhw.controller;

import com.guryasha.graphqlhw.entity.TaskEntity;
import com.guryasha.graphqlhw.service.TaskService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphqlTaskController {
    private TaskService taskService;

    @QueryMapping
    public Iterable<TaskEntity> findAll(@Argument int count, @Argument int offset) {
        return taskService.returnTasks(count, offset);
    }

    @QueryMapping
    public TaskEntity createTask(@Argument String title, @Argument String desc) {
        return taskService.saveTask(title, desc);
    }
}
