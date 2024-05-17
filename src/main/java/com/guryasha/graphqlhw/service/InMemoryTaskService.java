package com.guryasha.graphqlhw.service;
import com.guryasha.graphqlhw.dao.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryTaskService implements TaskService{
    private final List<TaskEntity> tasks = new LinkedList<>();

    @Override
    public Iterable<TaskEntity> returnTasks(int count, int offset) {
        List<TaskEntity> result = new ArrayList<>();
        int size = tasks.size();
        for (int i = offset; i < size && result.size() < count; i++) {
            result.add(tasks.get(i));
        }
        return result;
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