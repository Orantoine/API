package fr.Orantoine.APIJAVA.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import fr.Orantoine.APIJAVA.models.Session;
import fr.Orantoine.APIJAVA.models.User;
import fr.Orantoine.APIJAVA.repositories.SessionRepository;
import fr.Orantoine.APIJAVA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/authent")
public class SessionController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping(path = "/")
    public ResponseEntity<String> authent(@RequestBody User user){
        User user1 = userRepository.findByPseudoAndPassword(user.getPseudo(), user.getPassword());
        if(user1 == null){
            return ResponseEntity.notFound().build();
        }
        Date dateactu = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateactu);
        calendar.add(Calendar.MINUTE,1); //temps d'expiration d'une session 2 heures
        Date expiration = calendar.getTime();
        Session sessions = sessionRepository.findSessionByUserAndExpirementIsAfter(user1,dateactu);
        if(sessions == null){
            SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[128];
            random.nextBytes(bytes);
            String token = bytes.toString();
            Session session = new Session();
            session.setToken(token);
            session.setCreation(dateactu);
            session.setExpirement(expiration);
            session.setUser(user1);
            sessionRepository.save(session);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("token",session.getToken());
            return ResponseEntity.ok().headers(responseHeaders).body("{" +
                    "\"message\": \"Vous êtes bien connecté\" }");
        }
        else{
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("token",sessions.getToken());
            return ResponseEntity.ok().headers(responseHeaders).body("{" +
                    "\"message\": \"Bon retour parmis nous\" }");
        }
    }

    @GetMapping(path = "/sessions")
    public ResponseEntity<List<Session>> listSession(@RequestHeader String token) {
        Date date = new Date();
        Session session = sessionRepository.findSessionByTokenAndExpirementIsAfter(token, date);
        if (session != null){
            if (session.getUser().isAdmin())
                return ResponseEntity.ok().body(sessionRepository.findAll());
        }
        return ResponseEntity.notFound().build();
    }
}
