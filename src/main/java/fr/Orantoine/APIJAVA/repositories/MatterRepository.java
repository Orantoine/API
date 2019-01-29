package fr.Orantoine.APIJAVA.repositories;

import fr.Orantoine.APIJAVA.models.Matter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatterRepository extends MongoRepository<Matter,String> {
}
