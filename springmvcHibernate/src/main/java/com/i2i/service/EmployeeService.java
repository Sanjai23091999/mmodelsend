package com.i2i.service;

import com.i2i.entity.Employee;

import java.util.List;


public interface EmployeeService<T> {

    public List<T> getEmployees();

    public void saveEmployee(T saveEmployee);
    public void deleteEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public Employee getEmployeeById(int id);
}