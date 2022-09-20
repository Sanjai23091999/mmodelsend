package com.i2i.dao;

import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;

import java.util.List;



public interface EmployeeDao<T> {

    public void saveTrainee(Trainee trainee);

    public void saveTrainer(Trainer trainer);

    public List <Trainee> getTrainees();

    public List <Trainer> getTrainers();

    public void deleteTrainee(Trainee trainee);

    public void deleteTrainer(Trainer trainer);

    public void updateTrainee(Trainee trainee);

    public Trainee getTraineeById(int id);

    public Trainer getTrainerById(int id);

}