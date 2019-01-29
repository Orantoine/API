package fr.Orantoine.APIJAVA.repositories;

import fr.Orantoine.APIJAVA.models.Notes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Notes,String> {
}
