package com.nofal.jobtrack_project.entity;


import com.nofal.jobtrack_project.enums.JobWorkstyle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "jobs", schema="fsweb")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobId;

    @Enumerated(EnumType.STRING)
    @Column(name="job_workstyle")
    private JobWorkstyle jobWorkstyle;

    @Column(name = "job_title")
    private String jobTitle;

    @OneToMany(mappedBy = "job")
    private List<Application> applications;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
