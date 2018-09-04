package com.todo.spring.services.base;

import com.todo.spring.models.Todo;

import java.util.List;

public interface TodosService {

    List<Todo> getAllTodos();

    Todo findTodoById(int id);

    Todo create(Todo todo);

}
