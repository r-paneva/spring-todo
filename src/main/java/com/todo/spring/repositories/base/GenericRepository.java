package com.todo.spring.repositories.base;


import com.todo.spring.models.base.ModelBase;
import java.util.List;

public interface GenericRepository<T extends ModelBase> {
    List<T> findAll();

    T findById(int id);

    void add(T todo);
}