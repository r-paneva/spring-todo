package com.todo.spring.repositories.base;


import com.todo.spring.models.base.ModelBase;
import java.util.List;

public interface GenericRepository<T extends ModelBase> {
    List<T> findAll();

    T findById(int id);

    T create (T item);

    void update (int id, T item);

    void delete (int id);
}