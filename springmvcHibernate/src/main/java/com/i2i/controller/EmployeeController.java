package com.i2i.controller;


import com.i2i.entity.Employee;
import com.i2i.entity.Trainee;
import com.i2i.entity.Trainer;
import com.i2i.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.NoResultException;
import java.util.List;

/**
 * <p>
 * EmployeeController class with the helps of getting inputs
 * from user and passing to employee service.
 * </p>
 *
 * @author Sanjai king
 *
 * @version 1
 *
 * @since 2022-07-18
 */
@Controller
public class EmployeeController{


    @Autowired
    private EmployeeService employeeService;



    @PostMapping("/saveTrainee")
    public ModelAndView addTrainee(@ModelAttribute("trainee") Trainee trainee){

        employeeService.saveEmployee(trainee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }



    @PostMapping("/saveTrainer")
    public ModelAndView addTrainer(@ModelAttribute("trainer") Trainer trainer){

        employeeService.saveEmployee(trainer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @RequestMapping("/saveTraineeForm")
    public ModelAndView showTrainee(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saveTraineeForm");
        modelAndView.addObject("trainee",new Employee());
        return modelAndView;

    }

    @RequestMapping("/saveTrainerForm")
    public ModelAndView showTrainer(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("saveTrainerForm");
        modelAndView.addObject("trainer",new Employee());
        return modelAndView;
    }

   @RequestMapping("/DisplayAllTrainees")
    public ModelAndView displayAllTrainee(){
        List<Trainee> trainees = employeeService.getTrainees();
        return new ModelAndView("DisplayAllTrainees","trainees",trainees);
    }

    @RequestMapping("/DisplayAllTrainers")
    public ModelAndView displayAllTrainer(){
        List<Trainer> trainers = employeeService.getTrainers();
        return new ModelAndView("DisplayAllTrainers","trainers",trainers);
    }

    @RequestMapping("/updateTrainee")
    public ModelAndView updateTraineeForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateTraineeForm");
        modelAndView.addObject("trainee",new Trainee());
        return modelAndView;
    }

    @RequestMapping("/updateTrainer")
    public ModelAndView updateTrainerForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateTrainerForm");
        modelAndView.addObject("trainer",new Trainer());
        return modelAndView;
    }

    @PostMapping ("/updateTrainee")
    public ModelAndView updateTrainee(@ModelAttribute("trainee") Trainee updateTrainee){
        Trainee trainee = employeeService.getTraineeById(updateTrainee.getEmployeeId());
        trainee.setEmployeeEmail(updateTrainee.getEmployeeEmail());
        employeeService.updateEmployee(trainee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @PostMapping ("/updateTrainer")
    public ModelAndView updateTrainer(@ModelAttribute("trainer") Trainer updateTrainer){
        Trainer trainer = employeeService.getTrainerById(updateTrainer.getEmployeeId());
        trainer.setEmployeeEmail(updateTrainer.getEmployeeEmail());
        employeeService.updateEmployee(trainer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @PostMapping ("/deleteTrainee")
    public ModelAndView deleteTrainee(@ModelAttribute("trainee") Trainee deleteTrainee){
        Trainee trainee = employeeService.getTraineeById(deleteTrainee.getEmployeeId());
        trainee.setIsActiveEmployee(1);
        employeeService.deleteEmployee(trainee);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @RequestMapping("/deleteTraineeForm")
    public ModelAndView showTraineeDeleteForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteTraineeForm");
        modelAndView.addObject("trainee",new Trainee());
        return modelAndView;
    }

    @PostMapping ("/deleteTrainer")
    public ModelAndView deleteTrainer(@ModelAttribute("trainer") Trainer deleteTrainer){
        Trainer trainer = employeeService.getTrainerById(deleteTrainer.getEmployeeId());
        trainer.setIsActiveEmployee(1);
        employeeService.deleteEmployee(trainer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;
    }

    @RequestMapping("/deleteTrainerForm")
    public ModelAndView showTrainerDeleteForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("deleteTrainerForm");
        modelAndView.addObject("trainer",new Trainer());
        return modelAndView;
    }

    @PostMapping("/displayTrainee")
    public ModelAndView getTraineeById(@ModelAttribute("trainee") Trainee displayTrainee){
        Trainee trainee = employeeService.getTraineeById(displayTrainee.getEmployeeId());
        return new ModelAndView("DisplayTraineeByIdView","trainee",trainee);
    }

    @RequestMapping("/displayTraineeById")
    public ModelAndView displayTraineeById(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("DisplayTraineeById");
        modelAndView.addObject("trainee",new Trainee());
        return modelAndView;
    }

    @PostMapping("/displayTrainer")
    public ModelAndView getTrainerById(@ModelAttribute("trainer") Trainee displayTrainer){
        Trainer trainer = employeeService.getTrainerById(displayTrainer.getEmployeeId());
        return new ModelAndView("DisplayTrainerByIdView","trainer",trainer);
    }

    @RequestMapping("/displayTrainerById")
    public ModelAndView displayTrainerById(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("DisplayTrainerById");
        modelAndView.addObject("trainer",new Trainer());
        return modelAndView;
    }

    @RequestMapping("/associate")
    public ModelAndView displayTraineeForAssociate(){
            List<Trainee> trainees = employeeService.getTrainees();
            return new ModelAndView("DisplayAllTrainees","trainees",trainees);
    }

    @RequestMapping("/AssociateTrainee")
    public ModelAndView associateTrainee(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("associateTrainee");
        return modelAndView;

    }

    @RequestMapping("/Associate")
    public ModelAndView associateTrainee(@RequestParam("traineeId")String traineeId, @RequestParam("trainerId")String trainerId){

        Trainer trainer = employeeService.getTrainerById(trainerId);
        Trainee trainee = employeeService.getTraineeById(traineeId);
        trainer.getTrainees().add(trainee);
        employeeService.updateEmployee(trainer);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view2");
        return  modelAndView ;

    }

    @ExceptionHandler(value = NoResultException.class)
    public String exceptionHandler(Model model) {
        model.addAttribute("err", "Id Doesn't exists.... Please Enter a Valid Id");
        return "error";
    }



}