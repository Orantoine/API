package fr.Orantoine.APIJAVA.repositories;

import fr.Orantoine.APIJAVA.models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface SessionRepository extends MongoRepository<Session,String> {

}
