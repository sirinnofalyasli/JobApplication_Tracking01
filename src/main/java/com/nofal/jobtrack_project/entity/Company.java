package com.nofal.jobtrack_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="companies", schema="fsweb")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    @Column(name ="company_name")
    private String companyName;

    @Column(name = "company_location")
    private String companyLocation;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
}
