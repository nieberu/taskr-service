package com.daimler.taskrservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Table(name = "Team")//Defining the table name in our database
@Entity //Defines an object for our table
@Getter //These 4 annotations are from Lombok to reduce development time
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//This prevents the lazy initialization error due to nested objects
public class Team {

    //Defining an ID as primary key and defining the columns of the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teamid",updatable=false,nullable=false)
    private long teamid;

    @Column(name="teamname")
    private String teamname;

}
