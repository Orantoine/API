package fr.Orantoine.APIJAVA.repositories;

import fr.Orantoine.APIJAVA.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String > {
}
