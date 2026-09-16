package com.nofal.jobtrack_project.controller;

import com.nofal.jobtrack_project.entity.Job;
import com.nofal.jobtrack_project.entity.Note;
import com.nofal.jobtrack_project.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    @GetMapping // get all notes
    public List<Note> findAll(){
        return noteService.findAll();
    }
    @GetMapping("/{id}") // get by id
    public Note findById(@PathVariable Integer id){
        return noteService.findById(id);
    }
    @PostMapping("/") // creating new note
    public Note save(@RequestBody Note note){
        return noteService.save(note);
    }
    @PutMapping("/{id}")  // update note
    public Note update(@PathVariable Integer id, @RequestBody Note note){
        Note existingNote = noteService.findById(id);
        existingNote.setLatestNote(note.getLatestNote());

        noteService.save(existingNote);
        return existingNote;
    }

    @DeleteMapping("/{id}") // delete by id
    public void delete(@PathVariable Integer id){
        noteService.deleteById(id);
    }

}
