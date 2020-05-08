package com.daimler.taskrservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "TeamMember") //Defining the table name in our database
@Entity //Defines an object for our table
@Getter //These 4 annotations are from Lombok to reduce development time
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//This prevents the lazy initialization error due to nested objects
public class TeamMember {

    //Defining an ID as primary key and defining the columns of the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="teammemberid",updatable=false,nullable=false)
    private long teammemberid;

    @Column(name="name")
    private String name;

    @Column(name="availability")
    private boolean availability;

    @OneToOne
    @JoinColumn(name = "teamid")
    private Team team;

    public boolean getAvailability(){return availability;}
}
