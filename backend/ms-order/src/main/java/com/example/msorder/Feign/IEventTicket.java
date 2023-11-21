package com.example.msorder.Feign;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*
@FeignClient(name = "event",url = "http://localhost:8081")
@LoadBalancerClient(configuration= LoadBalancerConfiguration.class, name= "event", value = "event")
public interface IEventTicket {
    @RequestMapping(method = RequestMethod.GET, value = "/events/{id}")
    EventDTO eventByID(@PathVariable Long id);

    @Getter
    @Setter
    @ToString
    class EventDTO {

        public Long ID;

        private String name;

    }
}*/
