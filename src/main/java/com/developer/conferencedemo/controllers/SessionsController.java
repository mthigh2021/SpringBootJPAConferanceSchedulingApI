package com.developer.conferencedemo.controllers;


import com.developer.conferencedemo.Repository.SessionRepository;
import com.developer.conferencedemo.models.Session;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")

public class SessionsController {
   @Autowired
    private SessionRepository sessionRepository;

   @GetMapping
   public List<Session> list(){
     return sessionRepository.findAll();

   }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id ){
        return sessionRepository.findById(id).get();
    }


//@PostMapping
  // @ResponseStatus(HttpStatus.CREATED)
//   public Session create(@RequestBody final Session session){
//       return sessionRepository.saveAndFlush(session);
//   }

@PostMapping
public Session create(@RequestBody final Session session){
  return sessionRepository.saveAndFlush(session);
    }

       @RequestMapping(value = "{id}", method= RequestMethod.DELETE)
        public void delete(@PathVariable Long id){
       //also need to check for children records before deleting
       sessionRepository.deleteById(id);
        }

        @RequestMapping(value = "{id}", method = RequestMethod.PUT)
        public Session update (@PathVariable Long id, @RequestBody Session session){
               // because this is a put, we expect all attributes to be passed in.
                // a Patch would only need  what
                // todo : add validation that all attributes are passed in, otherwise return a bad 400 payload
               Session existingSession = sessionRepository.findById(id).get();
               BeanUtils.copyProperties(session, existingSession, "session_id");
               return sessionRepository.saveAndFlush(existingSession);


               }

}
