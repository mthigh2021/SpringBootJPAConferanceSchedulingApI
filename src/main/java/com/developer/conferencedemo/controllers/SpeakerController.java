package com.developer.conferencedemo.controllers;


import com.developer.conferencedemo.Repository.SpeakerRepository;
import com.developer.conferencedemo.models.Speaker;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Speaker")
public class SpeakerController {
    @Autowired
     private SpeakerRepository speakerRepository;


    @GetMapping
    public List<Speaker> list(){
        List<Speaker> listOfSpeaker = null;
        
        try{
         listOfSpeaker =  speakerRepository.findAll();
        }
        catch(Exception ex)
        {
            String error = ex.toString();
        }
        return listOfSpeaker;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id){
         Speaker speaker = new Speaker();
        try {
            speaker =    speakerRepository.findById(id).get();
            String x= "";
        }
        catch(Exception ex){
            String error = ex.toString();
        }
        return speaker;
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method= RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //also need to check for children records before deleting
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}",method =RequestMethod.PUT)
    public Speaker update (@PathVariable Long id, @RequestBody Speaker speaker){
        // because this is a put, we expect all attributes to be passed in.
        // a Patch would only need  what
        // todo : add validation that all attributes are passed in, otherwise return a bad 400 payload
        Speaker existingSpeaker = speakerRepository.findById(id).get();
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);


    }

}
