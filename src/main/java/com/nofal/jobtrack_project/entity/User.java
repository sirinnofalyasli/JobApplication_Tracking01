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
@Table(name = "users", schema="fsweb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_lastname")
    private String userLastName;

    @Column(name = "user_jobtitle")
    private String jobTitle;

    @OneToMany(mappedBy = "user")
    private List<Application> applications;

}
