package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
@Table(name = "tasks")
public class Task {
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank
	@Size(min = 3, max = 200)
	@Column(name = "name")
	private String name;
	
	@Column(name = "priority")
	private String priority;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "state_id")
	private State state;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "todo_id")
	private ToDo todo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public ToDo getTodo() {
		return todo;
	}

	public void setTodo(ToDo todo) {
		this.todo = todo;
	}

	public long getId() {
		return id;
	}
	
	
}
