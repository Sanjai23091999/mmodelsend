package com.i2i.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Autowired
    private T employee;

    @Override
    @Transactional
    public void saveEmployee(T saveEmployee) {
        if (employee instanceof Trainee) {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.save((Trainee)saveEmployee);
        } else {
            Session currentSession = sessionFactory.getCurrentSession();
            currentSession.save((Trainer)saveEmployee);
        }
    }
    @Override
    @Transactional
    public List<T> getEmployees() {
        if (employee instanceof Trainee) {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Trainee> criteriaQuery = criteriaBuilder.createQuery(Trainee.class);
            Root<Trainee> root = criteriaQuery.from(Trainee.class);
            criteriaQuery.select(root);
            Query query = session.createQuery(criteriaQuery);
            return (List<T>)query.getResultList();
        } else {
            Session session = sessionFactory.getCurrentSession();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery < Trainer > criteriaQuery = criteriaBuilder.createQuery(Trainer.class);
            Root< Trainer > root = criteriaQuery.from(Trainer.class);
            criteriaQuery.select(root);
            Query query = session.createQuery(criteriaQuery);
            return (List<T>)query.getResultList();
        }
    }

    @Override
    @Transactional
    public void updateEmployee(T updateEmployee) {
        if (employee instanceof Trainee){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(()updateEmployee);
    }

    @Override
    @Transactional
    public void updateTrainer(Trainer trainer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(trainer);
    }

    @Override
    @Transactional
    public Trainee getTraineeById(int id){
        Session currentSession = sessionFactory.getCurrentSession();
        Trainee trainee = (Trainee) currentSession.get(Trainee.class, id);
        return trainee;
    }

    @Override
    @Transactional
    public Trainer getTrainerById(int id){
        Session currentSession = sessionFactory.getCurrentSession();
        Trainer trainer = (Trainer) currentSession.get(Trainer.class, id);
        return trainer;
    }


}