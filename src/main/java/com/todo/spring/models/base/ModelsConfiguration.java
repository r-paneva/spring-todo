package com.todo.spring.models.base;

import com.todo.spring.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//
@Configuration
public class ModelsConfiguration {

    @Bean
    public Class<Todo> provideSuperheroClass() {
        return Todo.class;
    }

}
