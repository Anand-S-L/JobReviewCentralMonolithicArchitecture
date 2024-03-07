package com.anand.MonolithicSpring.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "job_table")
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;
    @ManyToOne
    private Company company;
}
