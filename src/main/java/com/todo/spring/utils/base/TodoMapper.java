package com.todo.spring.utils.base;

import com.todo.spring.models.Todo;
import com.todo.spring.viewmodels.TodoDetailsViewModel;
import com.todo.spring.viewmodels.TodoViewModel;

import java.util.List;

public interface TodoMapper {

    TodoViewModel map (Todo model);

    Todo map(TodoViewModel viewModel);

    List<TodoViewModel> mapMany(List<Todo> models);

    TodoDetailsViewModel mapDetails(Todo model);
}
