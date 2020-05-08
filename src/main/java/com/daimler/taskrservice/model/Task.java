package com.daimler.taskrservice.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Table(name = "Task")//Defining the table name in our database
@Entity //Defines an object for our table
@Getter //These 4 annotations are from Lombok to reduce development time
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})//This prevents the lazy initialization error due to nested objects
public class Task {

    //Defining an ID as primary key and defining the columns of the table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="taskid",updatable=false,nullable=false)
    private long taskid;

    @Column(name="startDate")
    private Date startDate;

    @Column(name="endDate")
    private Date endDate;

    @OneToOne
    @JoinColumn(name = "teammemberid")
    private TeamMember teammember;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private boolean status;

    @Column(name="help")
    private boolean help;

    public boolean getHelp(){return help;}

    public boolean getStatus(){return status;}
}
