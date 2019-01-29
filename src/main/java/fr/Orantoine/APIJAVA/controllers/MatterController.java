package fr.Orantoine.APIJAVA.controllers;

import fr.Orantoine.APIJAVA.models.Matter;
import fr.Orantoine.APIJAVA.repositories.MatterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/matters")
public class MatterController {

    @Autowired
    private MatterRepository matterRepository;

    @GetMapping(path = "/")
    public ResponseEntity<List<Matter>> listMatter(){
        return ResponseEntity.ok().body(matterRepository.findAll());
    }
    @PostMapping(path = "/")
    public ResponseEntity<Matter> addMatter(@RequestBody Matter matter){
        matterRepository.save(matter);
        return ResponseEntity.ok(matter);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteMatter(@PathVariable String id){
        matterRepository.deleteById(id);
        return ResponseEntity.ok().body(
                "{" +
                        "\"message\" : \"Bien supprimé\""+
                        "}"
        );
    }
}
