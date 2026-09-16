package com.nofal.jobtrack_project.service;

import com.nofal.jobtrack_project.entity.Note;
import com.nofal.jobtrack_project.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public Note save(Note note){
        return noteRepository.save(note);
    }
    public List<Note> findAll(){
        return noteRepository.findAll();
    }
    public Note findById(Integer id){
        Optional<Note> optionalNote = noteRepository.findById(id);
        if(optionalNote.isPresent()){
            return optionalNote.get();
        } else {
            throw new RuntimeException("Note not found. " + id);
        }
    }
    public void deleteById(Integer id){
        if(!noteRepository.existsById(id)){
            throw new RuntimeException("Note not found. " + id);
        }
        noteRepository.deleteById(id);
    }

}
