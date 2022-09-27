package com.i2i.service;

import java.util.List;

import com.i2i.dao.EmployeeDao;
import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl<T extends Employee> implements EmployeeService<T> {

    @Autowired

    private EmployeeDao employeeDao;


    @Override
    public void saveEmployee(T employee) {
        if (employee instanceof Trainer) {
            employeeDao.saveEmployee( employee);
        } else {
            employeeDao.saveEmployee( employee);
        }
    }

    /**
     * Retrieve list of  All Employees
     * @return {@link List} of {@link T}
     */
    @Override
    public List<Trainee> getTrainees() {
        return  employeeDao.retriveAllTrainees();
    }

    /**
     * Retrieve list of  All Employees
     * @return {@link List} of {@link T}
     */
    @Override
    public List<Trainer> getTrainers() {
            return employeeDao.retriveAllTrainers();
    }

    @Override
    public Trainee getTraineeById(String id) {
        return  employeeDao.getTraineeById(id);
    }

    @Override
    public Trainer getTrainerById(String id) {
        return  employeeDao.getTrainerById(id);
    }

    @Override
    public void deleteEmployee(T deleteEmployee) {
            employeeDao.updateEmployee(deleteEmployee);
    }

    @Override
    public void updateEmployee(T updateEmployee) {

            employeeDao.updateEmployee(updateEmployee);
    }

}