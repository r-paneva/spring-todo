package com.todo.spring.repositories;

import com.todo.spring.models.Todo;
import com.todo.spring.models.base.ModelBase;
import com.todo.spring.repositories.base.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class InMemoryRepositoryImpl<T extends ModelBase> implements GenericRepository<T> {

    private List<T> todos = new ArrayList<>();

    @Override
    public List<T> findAll() {
        return this.todos;
    }


    @Override
    public T findById(int id) {
        return getTodo(id);
    }


    @Override
    public void create (T todo) {
        int nextId = this.getNextId();
        todo.setId(nextId);
        this.todos.add(todo);
    }


    @Override
    public void update(int id, T todo) {
        T t = getTodo(id);
        int index = todos.indexOf(t);
        todos.set(index, todo);
    }


    @Override
    public void delete(int id) {
        T t =  getTodo(id);
        todos.remove(t);
    }


    private T getTodo(int id) {
        return this.todos.stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElse(null);
    }


    private int getNextId() {
        int biggestId = this.todos.stream()
                .mapToInt(ModelBase::getId)
                .max()
                .orElse(0);
        return biggestId + 1;
    }
}

