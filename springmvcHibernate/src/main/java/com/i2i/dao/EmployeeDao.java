package com.i2i.dao;

import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Employee dao interface used to manipulate details
 * in database
 * </p>
 *
 * @author Sanjai king
 *
 * @version 1
 *
 * @since 2022-07-18
 */
@Repository
public interface EmployeeDao<T extends Employee> {

    /**
     *used to insert Employee into List
     *@param employee {@link T} the employee object
     *@return {void}
     */
    public void saveEmployee(T employee);

    /**
     * Retrive list of  All Employees
     * @return {@link List} of {@link T}
     */
    public List<Trainee> retriveAllTrainees();

    /**
     * Retrive list of  All Employees
     * @return {@link List} of {@link T}
     */
    public List<Trainer> retriveAllTrainers();

    /**
     * Retrive  Employee with his id
     * @param employeeId {@link String} id of employee
     * @return {@link T} the employee object
     */
    public Trainer  getTrainerById(String employeeId);

    /**
     * Retrive  Employee with his id
     * @param employeeId {@link String} id of employee
     * @return {@link T} the employee object
     */
    public Trainee  getTraineeById(String employeeId);

    /**
     * used to update  Employee
     * @param updateEmployee {@link Employee} the employee object
     * @return {void}
     */
    public void updateEmployee(T updateEmployee);


}