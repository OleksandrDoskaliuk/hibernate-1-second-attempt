package com.softserve.itacademy.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "role_sequence"),
                    @Parameter(name = "initial_value", value = "10"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private long id;

    @NotBlank(message = "The roleName cannot be empty")
    @Size(min = 2, max = 254)
    @Column(nullable = false, unique = true)  
    private String name;

	
	@OneToMany(mappedBy = "role")
	private List<User> users;
	 

    public Role() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	
	public List<User> getUsers() { return users; }
	 
	public void setUsers(List<User> users) { this.users = users; }
	

    public void setId(long id) {
		this.id = id;
	}

	@Override
    public String toString() {
        return "Role {" +
                "id = " + id +
                ", name = '" + name + '\'' +
                "} ";
    }

}