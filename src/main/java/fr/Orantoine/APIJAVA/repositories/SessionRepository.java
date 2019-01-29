package fr.Orantoine.APIJAVA.repositories;

import fr.Orantoine.APIJAVA.models.Session;
import fr.Orantoine.APIJAVA.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface SessionRepository extends MongoRepository<Session,String> {

    Session findSessionByTokenAndExpirementIsAfter(String token, Date experiment);
    Session findByToken(String token);
    Session findSessionByUserAndExpirementIsAfter(User user, Date experiment);
}
