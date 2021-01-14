package com.softserve.itacademy.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "todos")
public class ToDo {
	@Id
	@GeneratedValue
	private long id;
	
	public ToDo() {
		createdAt = LocalDateTime.now();
	}
	
	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	LocalDateTime createdAt;
	
	@NotBlank
	@Column(name = "title", nullable = false,unique = true)
	private String title;
	
	@OneToMany(mappedBy = "todo",
			cascade = CascadeType.ALL)
	private List<Task> tasks;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "owner_id")
	private User owner;
	
	@ManyToMany(mappedBy = "myTodos")
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public long getId() {
		return id;
	}
	
	
}
