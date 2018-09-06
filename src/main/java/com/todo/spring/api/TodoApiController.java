package com.todo.spring.api;


import com.todo.spring.models.Todo;
import com.todo.spring.services.base.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")

public class TodoApiController {

    private final TodosService todosService;

    @Autowired
    public TodoApiController(TodosService todosService) {
        this.todosService = todosService;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todosService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById (@PathVariable int id) {
        return todosService.getTodoById(id);
    }

    @PostMapping
    public void createTodo(@RequestBody Todo todo) {
        todosService.create(todo);
    }
}
