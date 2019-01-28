package fr.Orantoine.APIJAVA.controllers;

import fr.Orantoine.APIJAVA.models.Movie;
import fr.Orantoine.APIJAVA.models.Session;
import fr.Orantoine.APIJAVA.repositories.MovieRepository;
import fr.Orantoine.APIJAVA.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping(path = "/")
    public List<Movie> listMovies(@RequestHeader String token){
        Session session = sessionRepository.findByToken(token);
        if (session == null)
            return null;
        return movieRepository.findAll();
    }

    @PostMapping(path = "/")
    public Movie addMovie(@RequestHeader String token, @RequestBody Movie movie){
        Session session = sessionRepository.findByToken(token);
        if (session == null)
            return null;
        movieRepository.save(movie);
        return movie;
    }
}
