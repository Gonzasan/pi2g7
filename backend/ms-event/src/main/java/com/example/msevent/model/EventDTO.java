package com.example.msevent.model;

import com.example.msevent.Feign.ITicketFeign;

import java.util.List;

public class EventDTO {

    private Event event;

    private List<ITicketFeign.TicketDTO> ticketDTOList;

    public EventDTO(Event event, List<ITicketFeign.TicketDTO> ticketDTOList) {
        this.event = event;
        this.ticketDTOList = ticketDTOList;
    }
}
