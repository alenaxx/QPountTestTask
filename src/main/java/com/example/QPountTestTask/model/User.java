package com.example.QPountTestTask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotBlank
    private Long id;
    private String firstName;
    private String lastName ;
    @OneToMany(mappedBy="user")
    private Set<Order> order= new HashSet<>();

    public User(Long id, String firstName, String lastName) {
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }
}
