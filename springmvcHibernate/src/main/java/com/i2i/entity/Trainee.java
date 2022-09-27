package com.i2i.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@NamedQueries(
        {
                @NamedQuery(
                        name = "retriveTraineeById",
                        query = "from Trainee trainee  where trainee.employeeId = :employeeId AND trainee.isActiveEmployee = :isActiveEmployee"
                ),
                @NamedQuery(
                        name = "retriveTrainees",
                        query = "from Trainee trainee where trainee.isActiveEmployee = :status"
                )
        }
)

@Entity
public class Trainee extends Employee {

    @Id
    @GeneratedValue
    private int traineeId;

    @ManyToMany(mappedBy = "trainees",fetch=FetchType.EAGER)
    private List<Trainer> trainers;


    public List<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

}
