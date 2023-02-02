package com.example.online_backend.controller;

import com.example.online_backend.model.Car;
import com.example.online_backend.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CarAPI {

    @Autowired
    private CarRepo carRepo;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("start_page");
        Car car = new Car();
        mav.addObject("card",car);
        return mav;
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute Car car){
        carRepo.save(car);
        return "redirect:/showcarinfo";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
        carRepo.deleteById(id);
        return "redirect:/showcarinfo";
    }
    /*
    @GetMapping("/table")
    public ModelAndView getAllEmplo(){
        ModelAndView mav = new ModelAndView("cartable");
        mav.addObject("employee",carRepo.findAll());
        return mav;
    }
    */

    @GetMapping("/showcarinfo")
    public  ModelAndView showcarinfo(){
        ModelAndView modelAndView = new ModelAndView("cartable");
        List<Car> carList = carRepo.findAll();
        modelAndView.addObject("carinfo",carList);
        return modelAndView;

    }

}