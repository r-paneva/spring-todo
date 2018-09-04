package com.todo.spring.services;

import com.todo.spring.models.Todo;
import com.todo.spring.repositories.base.GenericRepository;
import com.todo.spring.services.base.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodosServiceImpl implements TodosService {
    private final GenericRepository<Todo> todoRepository;

    @Autowired
    public TodosServiceImpl(GenericRepository<Todo> todoRepository) {
        this.todoRepository=todoRepository;
    }

    @Override
    public List<Todo> getAllTodos() {
        return this.todoRepository.findAll();
    }

    @Override
    public Todo findTodoById(int id) {
        return this.todoRepository.findById(id);
    }

    @Override
    public Todo create(Todo todo) {
        todoRepository.add(todo);
        return todo;
    }
}
