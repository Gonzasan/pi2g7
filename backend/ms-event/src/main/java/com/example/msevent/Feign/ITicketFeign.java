package com.example.msevent.Feign;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "ticket",url = "http://localhost:8089")
@LoadBalancerClient(configuration= LoadBalancerConfiguration.class,name= "ticket", value = "ticket")
public interface ITicketFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/ticket/event/{id}")
    List<TicketDTO> ticketsByEventID(@PathVariable Long id);

    @Getter
    @Setter
    @ToString
    class TicketDTO {

        private Long ID;

        private String name;

        private Double price;

    }
}
