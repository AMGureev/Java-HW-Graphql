package com.guryasha.graphqlhw.service;

import com.guryasha.graphqlhw.entity.TaskEntity;

public interface TaskService {
    TaskEntity saveTask(String title, String desc); // save task on list and return it
    Iterable<TaskEntity> returnTasks(int count, int offset); // return several tasks
}
