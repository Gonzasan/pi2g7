package com.example.msevent.controller;

import com.example.msevent.model.Event;
import com.example.msevent.model.EventDTO;
import com.example.msevent.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @GetMapping("/all")
    public ResponseEntity<List<Event>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> findbyID(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findbyID(id));
    }

    @GetMapping("/date")
    public ResponseEntity<List<Event>> findByDate(@RequestParam("date")
        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return ResponseEntity.ok().body(service.findByDate(date));
    }

    @GetMapping("/name")
    public ResponseEntity<List<Event>> findByName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(service.findByName(name));
    }
    @GetMapping("/artist")
    public ResponseEntity<List<Event>> findByArtistName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(service.findByArtistName(name));
    }
    @GetMapping("/category")
    public ResponseEntity<List<Event>> findByCategoryName(@RequestParam("name") String name) {
        return ResponseEntity.ok().body(service.findByCategoryName(name));
    }
    /*
    @GetMapping("/city")
    public ResponseEntity<List<Event>> findByVenueAddressCity(@RequestParam("name") String city) {
        return ResponseEntity.ok().body(service.findByVenueAddressCity(city));
    }*/

    @PostMapping
    public ResponseEntity<Event> save(@RequestBody Event event){
        return ResponseEntity.ok().body(service.save(event));
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        Event event = service.findbyID(id);
        if (event != null){
         service.delete(id);
         return ResponseEntity.ok("Deleted successfully");}
        return ResponseEntity.notFound().build();
    }*/

    @PutMapping("/{id}")
    public ResponseEntity<Event> put(@RequestBody Event event){
        return ResponseEntity.ok().body(service.update(event));
    }



}
