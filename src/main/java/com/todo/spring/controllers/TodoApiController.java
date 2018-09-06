package com.todo.spring.controllers;


import com.todo.spring.models.Todo;
import com.todo.spring.services.base.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")

public class TodoApiController {

    private final TodosService service;

    @Autowired
    public TodoApiController(TodosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById (@PathVariable int id) {
        return service.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return service.create(todo);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Todo todo){
        service.update(id,todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
}
