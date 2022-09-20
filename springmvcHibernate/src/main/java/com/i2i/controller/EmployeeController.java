package com.i2i.controller;


import com.i2i.entity.Employee;
import com.i2i.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController{

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @RequestMapping("/saveForm")
    public ModelAndView showform(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saveForm");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @RequestMapping("/Display")
    public ModelAndView displayForm(){
        List<Employee> employees = employeeService.getEmployees();
        return new ModelAndView("Display","employees",employees);
    }

    @RequestMapping("/update")
    public ModelAndView updateform(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateForm");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @PostMapping ("/updateEmployee")
    public ModelAndView updateEmployee(@ModelAttribute("employee") Employee updateEmployee){
        Employee employee = employeeService.getEmployeeById(updateEmployee.getId());
        employee.setEmail(updateEmployee.getEmail());
        employeeService.updateEmployee(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @PostMapping ("/deleteEmployee")
    public ModelAndView deleteEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.deleteEmployee(employee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @RequestMapping("/deleteForm")
    public ModelAndView showDeleteForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteForm");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }

    @RequestMapping("/displayByIdEmployee")
    public ModelAndView displayByIdForm(@ModelAttribute("employee") Employee displayEmployee){
        Employee employee = employeeService.getEmployeeById(displayEmployee.getId());
        return new ModelAndView("idView","employee",employee);
    }

    @RequestMapping("/displayById")
    public ModelAndView displayByIdform(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("displayById");
        modelAndView.addObject("employee",new Employee());
        return modelAndView;
    }
}