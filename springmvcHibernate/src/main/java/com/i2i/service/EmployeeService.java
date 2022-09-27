package com.i2i.service;

import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService<T extends Employee> {



    public void saveEmployee(T trainee);

    public List<Trainee> getTrainees();

    public List<Trainer> getTrainers();

    public Trainee getTraineeById(String id);

    public Trainer getTrainerById(String id);

    public void deleteEmployee(T deleteEmployee);

    public void updateEmployee(T updateEmployee);


  //  public void saveTrainer(Trainer trainer);

   /* public void deleteEmployee(T deleteEmployee);

    public void updateEmployee(T updateEmployee);

    public List<T> getEmployees();

    public Employee getEmployeeById(int id);*/
}