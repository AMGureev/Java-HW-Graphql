package com.guryasha.graphqlhw.service;
import com.guryasha.graphqlhw.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryTaskService implements TaskService{
    private final List<TaskEntity> tasks = new LinkedList<>();

    @Override
    public Iterable<TaskEntity> returnTasks() {
        return tasks;
    }

    @Override
    public TaskEntity saveTask(String title, String desc) {
        int maxId = -1;
        for (TaskEntity task : tasks) {
            if (task.getId() > maxId) {
                maxId = task.getId();
            }
        }
        int newId = maxId + 1;
        TaskEntity obj = new TaskEntity(newId, title, desc);
        tasks.add(obj);
        return obj;
    }
}