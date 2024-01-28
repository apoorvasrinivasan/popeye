package com.aspire.hackathon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aspire.hackathon.model.Todo;
import com.aspire.hackathon.repository.TodoRepository;

@Service
public class TodoService {
	private TodoRepository todoRepository;
	
	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	public List<Todo> getAll() {
		return todoRepository.findAll();
	}

	public Todo save(Todo todo) {
		return todoRepository.save(todo);
	}

	public Optional<?> findById(Long id) {
		return todoRepository.findById(id);
	}
}
