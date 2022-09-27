package com.i2i.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedQueries(
        {
                @NamedQuery(
                        name = "retriveTrainerById",
                        query = "from Trainer trainer  where trainer.employeeId = :employeeId AND trainer.isActiveEmployee = :isActiveEmployee"
                ),
                @NamedQuery(name = "retriveTrainers",
                        query = "from Trainer trainer where trainer.isActiveEmployee = :status")
        }
)
@Entity
public class Trainer extends Employee{

    @Id
    @GeneratedValue
    private int trainerId;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="Trainer_Trainee",joinColumns=@JoinColumn(name="Trainer_Id"),inverseJoinColumns=@JoinColumn(name="Trainee_Id"))
    private List<Trainee> trainees;


    public List<Trainee> getTrainees() {
        return trainees;
    }

    public void setTrainees(List<Trainee> trainees) {
        this.trainees = trainees;
    }


}
