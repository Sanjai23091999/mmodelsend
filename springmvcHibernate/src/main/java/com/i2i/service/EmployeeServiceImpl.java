package com.i2i.service;

import java.util.List;

import com.i2i.dao.EmployeeDao;
import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class EmployeeServiceImpl<T extends Employee> implements EmployeeService<T>{

    @Autowired
    private T employee;

    @Autowired
    private EmployeeDao<Trainer> trainerDao;

    @Autowired
    private EmployeeDao<Trainee> traineeDao;

    @Override
    @Transactional
    public List<T> getEmployees() {
        if (employee instanceof Trainee) {
            return (List<T>)traineeDao.getTrainees();
        } else {
            return (List<T>)trainerDao.getTrainers();
        }
    }

    @Transactional
    public void saveEmployee(T saveEmployee) {
        if(employee instanceof Trainee){
            traineeDao.saveTrainee((Trainee)saveEmployee);
        } else {
            trainerDao.saveTrainer((Trainer)saveEmployee);
        }
    }


    @Override
    @Transactional
    public void deleteTrainee(Trainee trainee) {
        employeeDao.deleteTrainee(trainee);
    }

    @Override
    @Transactional
    public void deleteTrainer(Trainer trainer) {
        employeeDao.deleteTrainer(trainer);
    }

    @Override
    @Transactional
    public void updateTrainee(Trainee trainee) {
        employeeDao.updateTrainee(trainee);
    }

    @Override
    @Transactional
    public void updateTrainer(Trainer trainer) {
        employeeDao.updateTrainer(trainer);
    }

    public Trainee getTraineeById(int id){
        return employeeDao.getTraineeById(id);
    }

    public Employee getTrainerById(int id){
        return employeeDao.getTrainerById(id);
    }
}