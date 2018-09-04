package com.todo.spring.api;


import com.todo.spring.models.Todo;
import com.todo.spring.services.base.TodosService;
import com.todo.spring.utils.base.TodoMapper;
import com.todo.spring.viewmodels.TodoDetailsViewModel;
import com.todo.spring.viewmodels.TodoViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/todos")

public class TodoApiController {

    private final TodosService todosService;
    private final TodoMapper mapper;

    @Autowired
    public TodoApiController(TodosService todosService, TodoMapper mapper) {
        this.todosService = todosService;
        this.mapper = mapper;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public List<TodoViewModel> getAllSuperheroes() {
        List<Todo> models = this.todosService.getAllTodos();
        return this.mapper.mapMany(models);
    }

    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET
    )
    public TodoDetailsViewModel getSuperheroById(@PathVariable("id") String idString) {
        int id = Integer.parseInt(idString);
        Todo model = this.todosService.findTodoById(id);
        return this.mapper.mapDetails(model);
    }

    @RequestMapping(
            method = RequestMethod.POST
    )
    public ResponseEntity<TodoViewModel> createSuperhero(@RequestBody TodoViewModel todoVm) {
        if (todoVm == null || todoVm.title == null || todoVm.description == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Superhero must have name and secret Identity");
        }
        Todo model = this.mapper.map(todoVm);
        Todo todo = this.todosService.create(model);
        TodoViewModel vmToReturn = this.mapper.map(todo);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vmToReturn);
    }
}
