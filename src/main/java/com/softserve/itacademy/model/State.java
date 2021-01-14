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
@Table(name = "states")
public class State {
	@Id
	@GeneratedValue
	private long id;
	
	@NotBlank
	@Column(name = "name", nullable = false,unique = true)
	@Size(min =1,max =20)
	@Pattern(regexp = "([^\"!\"#$%&'()*+,./:;<=>?@[\\]^`{|}~\"])+")
	private String name;
	
	@OneToMany(mappedBy = "state",
			cascade = CascadeType.ALL)
	private List<Task> tasks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public long getId() {
		return id;
	}
	
}
