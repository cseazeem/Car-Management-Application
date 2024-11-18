package com.cseazeem.carmanagement.Service;

import com.cseazeem.carmanagement.DataBase.CarDao;
import com.cseazeem.carmanagement.Entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarDao carDao;

    public void addCar(Car
                               car, Long userId) {
        carDao.insertCar(car.getTitle(), car.getDescription(), car.getTags(), userId);
    }

    public List<Car> getUserCars(Long userId) {
        return carDao.findByUserId(userId);
    }

    public List<Car> searchCars(String keyword) {
        return carDao.searchCars(keyword);
    }

    public Car getCarById(Long carId) {
        return carDao.findById(carId);
    }

    public void deleteCar(Long carId) {
        carDao.deleteById(carId);
    }
}

