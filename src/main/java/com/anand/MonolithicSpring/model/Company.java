package com.anand.MonolithicSpring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Job> jobs;
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

}
