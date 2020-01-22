package com.soma.application.repository;

import com.soma.application.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * This is similar to CrudRepository or JpaRepository.
 * But this for the MongoDB separately and created with the Reactive approach so we are using the ReactiveMongoRepository.
 * Because the return must be Mono or the Flux so the they have place this interface in the reactive package.
 * It contains all the methods which is same as CrudRepository
 */
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
