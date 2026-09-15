package com.nofal.jobtrack_project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "notes", schema="fsweb" )
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noteId;

    @Column(name = "latest_note")
    private String latestNote;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;
}
