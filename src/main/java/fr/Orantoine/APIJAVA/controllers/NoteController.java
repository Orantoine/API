package fr.Orantoine.APIJAVA.controllers;

import fr.Orantoine.APIJAVA.models.Notes;
import fr.Orantoine.APIJAVA.models.Session;
import fr.Orantoine.APIJAVA.repositories.MatterRepository;
import fr.Orantoine.APIJAVA.repositories.NoteRepository;
import fr.Orantoine.APIJAVA.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/notes")
public class NoteController {


    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private MatterRepository matterRepository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Notes>> listNotes(){
        return ResponseEntity.ok(noteRepository.findAll());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Notes> addNote(@RequestBody Notes notes,@RequestHeader String token){
        Date date = new Date();
        Session session = sessionRepository.findSessionByTokenAndExpirementIsAfter(token,date);
        if(session!= null) {
            notes.setUser(session.getUser());
            notes.setDate(date);
            noteRepository.save(notes);
            return ResponseEntity.ok(notes);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable String id){
        noteRepository.deleteById(id);
        return ResponseEntity.ok().body("Note supprimé avec succés");
    }
}
