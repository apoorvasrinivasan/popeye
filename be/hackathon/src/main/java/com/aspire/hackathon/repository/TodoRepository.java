package com.aspire.hackathon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aspire.hackathon.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	public Optional<Todo> findById(Long id);
}
