package com.soma.application.controller;

import com.soma.application.entity.Employee;
import com.soma.application.entity.EmployeeEvent;
import com.soma.application.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.awt.*;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/all")
    public Flux<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Employee> findById(@PathVariable("id") final String id) {
        return employeeRepository.findById(id);
    }

    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String id) {
        return employeeRepository.findById(id) // this line will return the data, this is going to return the Mono
                .flatMapMany(employee -> {
                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(3)); // Artificial delay of 3 seconds, Which means it is going to return the data in interval of 3 seconds
                    Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
                            Stream.generate(() -> new EmployeeEvent(employee, new Date()))
                    );

                    // now merge the the above flux
                    return Flux.zip(interval, employeeEventFlux)
                            .map(Tuple2::getT2);    // returns only the EmployeeEvent getT1() will return the time interval
                });
    }
}
