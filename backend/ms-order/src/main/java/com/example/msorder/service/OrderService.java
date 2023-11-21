package com.example.msorder.service;

//import com.example.msorder.Feign.IEventTicket;
import com.example.msorder.model.Order;
import com.example.msorder.repository.IOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final IOrderRepository repository;
   /* @Autowired
    private final IEventTicket feignto;

    public IEventTicket.EventDTO feigntick(Long id){
        return feignto.eventByID(id);
    }*/

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Optional<Order> findById(Long id){
        return repository.findById(id);
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Order update(Order order) {
        return repository.save(order);
    }

}
