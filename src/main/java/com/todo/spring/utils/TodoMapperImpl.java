package com.todo.spring.utils;

import com.todo.spring.models.Todo;
import com.todo.spring.utils.base.TodoMapper;
import com.todo.spring.viewmodels.TodoDetailsViewModel;
import com.todo.spring.viewmodels.TodoViewModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public TodoViewModel map(Todo model) {
        TodoViewModel vm = new TodoViewModel();
        vm.id = model.getId();
        vm.title = model.getTitle();
        vm.description = model.getDescription();
        vm.isActive = model.getStatus();
        return vm;
    }

    @Override
    public Todo map(TodoViewModel viewModel) {
        Todo model = new Todo();
        model.setTitle(viewModel.title);
        model.setDescription(viewModel.description);
        model.setStatus(true);
        return model;
    }

    @Override
    public List<TodoViewModel> mapMany(List<Todo> models) {
        return models.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDetailsViewModel mapDetails(Todo model) {
        TodoDetailsViewModel vm = new TodoDetailsViewModel();
        vm.id  = model.getId();
        vm.title = model.getTitle();
        vm.description = model.getDescription();
        vm.isActive = model.getStatus();
        return vm;
    }
}

