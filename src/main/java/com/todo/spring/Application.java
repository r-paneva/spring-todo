package com.todo.spring;

import com.todo.spring.models.Todo;
import com.todo.spring.repositories.base.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    @Autowired
    public Application(GenericRepository<Todo> todosRepository) {
        List<Todo> initialSuperheroes = Arrays.asList(
                new Todo("go to buy flowers",
                        "flowers for your grandmother's birthday",
                        true),
                new Todo("to finish my project",
                        "finish project and upload it to monday", true)
        );
        initialSuperheroes
                .forEach(todosRepository::add);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
