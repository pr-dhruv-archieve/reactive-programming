package com.soma.application.controller;

import com.soma.application.entity.Employee;
import com.soma.application.entity.EmployeeEvent;
import com.soma.application.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @GetMapping("/{id}/events")
    public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String id) {
        employeeRepository.findById(id)
                .flatMapMany(employee -> {

                    Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));
                    Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
                            Stream.generate(() -> new EmployeeEvent(employee, new Date()))
                    );
                    Flux.zip(interval, employeeEventFlux)
                            .map( )
                });

    }
}
