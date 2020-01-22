package com.soma.application.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor      // Generate No arg constructor
@AllArgsConstructor     // Generate parametric constructor
@Getter                 // Generate all getters
@Setter                 // Generate all setters
@ToString               // Generate toString()
@EqualsAndHashCode      // Generate boolean equals() and int hashCode()
@Document               // Create a Document for the MongoDb, like the RDMS database they store the model as Entity but in MongoDB which is NO-SQL it store the model as Documents.
@Data
public class Employee  {

    @Id     // defining the primary key
    private String id;
    private String name;
    private Double salary;


}
