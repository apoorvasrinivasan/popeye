package com.aspire.hackathon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.hackathon.model.Todo;
import com.aspire.hackathon.repository.TodoRepository;
import com.aspire.hackathon.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	
    private TodoService todoService;
    
    public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

    @GetMapping("/all")
    public List<Todo> getAll() {
        return todoService.getAll();
    }
    
    @PostMapping("/create")
    @ResponseBody
    public Todo create(@RequestBody Todo todo) {
      return todoService.save(todo);
    }
    
    @GetMapping(value = "fetch/{id}")
    @ResponseBody
    public Optional<?> get(@PathVariable Long id) {
        return todoService.findById(id);
    }

}
