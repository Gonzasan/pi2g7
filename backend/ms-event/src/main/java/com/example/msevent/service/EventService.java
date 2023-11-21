package com.example.msevent.service;

import com.example.msevent.Feign.ITicketFeign;
import com.example.msevent.model.Event;
import com.example.msevent.model.EventDTO;
import com.example.msevent.repository.IEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final IEventRepository repository;
    @Autowired
    private final ITicketFeign feignti;


    public List<Event> findAll() {
        return repository.findAll();
    }

    public Event save(Event event) {
        return repository.save(event);
    }

    public List<Event> findByName(String name){
        return repository.findByName(name);
    }

    public List<Event> findByDate(LocalDate date){
        return repository.findByDate(date);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    /*public Event findbyID(Long id) {
        List<IEventTicket.TicketDTO> ticketDTOS = feign.ticketsByEventID(id);
        Event event = repository.findAllByID(id).get();
        event.setTicketDTOList(ticketDTOS);
        return event;
    }*/

    public EventDTO findbyID(Long id) {

        List<ITicketFeign.TicketDTO> ticketDTOS = feignti.ticketsByEventID(id);
        Event event = repository.findAllByID(id).get();
        EventDTO eventDTO = new EventDTO(event,ticketDTOS);
        return eventDTO;
    }
/*
    public Event findbyID(Long id) {
        List<IEventTicket.TicketDTO> ticketDTOS = feign.ticketsByEventID(id);
        System.out.println(ticketDTOS.toString());
        Event event = repository.findAllByID(id).get();

        return event;
    }*/

    public Event update(Event event) {
        return repository.save(event);
    }


    public List<Event> findByArtistName(String name){
        return repository.findByArtistName(name);
    }
    public List<Event> findByCategoryName(String name){
        return repository.findByCategoryName(name);
    }

    /*public List<Event> findByVenueAddressCity(String city){
        return repository.findByVenueAddressCity(city);
    }*/

}
