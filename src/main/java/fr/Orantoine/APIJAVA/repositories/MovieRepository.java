package fr.Orantoine.APIJAVA.repositories;

import fr.Orantoine.APIJAVA.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
