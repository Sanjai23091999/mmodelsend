package com.i2i.dao;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDaoImpl<T extends Employee> implements EmployeeDao<T> {


    @Autowired
    private SessionFactory sessionFactory;

    /**
     *used to insert Employee into List
     *@param employee {@link T} the employee object
     *@return {void}
     */
    @Override
    @Transactional
    public void saveEmployee(T employee) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.save(employee);
    }

    /**
     * Retrive list of  All Employees
     * @return {@link List} of {@link T}
     */
    @Override
    @Transactional
    public List<Trainee> retriveAllTrainees() {

        Session currentSession = sessionFactory.getCurrentSession();

        TypedQuery query = currentSession.getNamedQuery("retriveTrainees");
        query.setParameter("status", 0);
         List<Trainee>  trainees = query.getResultList();

        return trainees;
    }

    /**
     * Retrive list of  All Employees
     * @return {@link List} of {@link T}
     */
    @Override
    @Transactional
    public List<Trainer> retriveAllTrainers(){

        Session currentSession = sessionFactory.getCurrentSession();

        TypedQuery query = currentSession.getNamedQuery("retriveTrainers");
        query.setParameter("status",0);
        List<Trainer> trainers = query.getResultList();
        return trainers;
    }

    /**
     * Retrive  Employee with his id
     * @param employeeId {@link String} id of employee
     * @return {@link T} the employee object
     */
    @Override
    @Transactional
    public Trainer  getTrainerById(String employeeId) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("retriveTrainerById");
        query.setParameter("employeeId", employeeId);
        query.setParameter("isActiveEmployee", 0);
        Trainer trainer = (Trainer) query.getSingleResult();
        return trainer;
    }

    /**
     * Retrive  Employee with his id
     * @param employeeId {@link String} id of employee
     * @return {@link T} the employee object
     */
    @Override
    @Transactional
    public Trainee getTraineeById(String employeeId) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("retriveTraineeById");
        query.setParameter("employeeId", employeeId);
        query.setParameter("isActiveEmployee", 0);
        Trainee trainee = (Trainee) query.getSingleResult();
        return trainee;
    }


    /**
     * used to update  Employee
     * @param updateEmployee {@link Employee} the employee object
     * @return {void}
     */
    @Override
    @Transactional
    public void updateEmployee(T updateEmployee) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.update( updateEmployee);
        }

}



