package com.cseazeem.carmanagement.Controller;

import com.cseazeem.carmanagement.Entities.Car;
import com.cseazeem.carmanagement.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public String addCar(@RequestBody Car car, @RequestParam Long userId) {
        carService.addCar(car, userId);
        return "Car added successfully!";
    }

    @GetMapping
    public List<Car> getUserCars(@RequestParam Long userId) {
        return carService.getUserCars(userId);
    }

    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam String keyword) {
        return carService.searchCars(keyword);
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return "Car deleted successfully!";
    }
}

