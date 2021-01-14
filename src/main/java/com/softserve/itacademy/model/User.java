package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank
	@Column(name = "email")
	@Email
	private String email;
	
	@NotBlank
	@Column(name = "first_name")
	@Pattern(regexp = "^([A-Z][a-z]+([ ]?[a-z]?['-]?[A-Z][a-z]+)*)$")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "role_id")
	private Role role;
	
	@OneToMany(mappedBy = "owner",
			cascade = CascadeType.ALL)
	private List<ToDo> todos;
	
	@ManyToMany
	@JoinTable(name = "todo_collaborator",
	joinColumns = @JoinColumn(name = "collaborator_id"),
	inverseJoinColumns = @JoinColumn(name = "todo_id"))
	private List<ToDo> myTodos;
	
	
	public List<ToDo> getMyTodos() {
		return myTodos;
	}

	public void setMyTodos(List<ToDo> myTodos) {
		this.myTodos = myTodos;
	}

	public List<ToDo> getTodos() {
		return todos;
	}

	public void setTodos(List<ToDo> todos) {
		this.todos = todos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}
	
	
}
