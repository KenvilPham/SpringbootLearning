package home.car2021.carcollection2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import home.car2021.carcollection2021.model.Car;
import home.car2021.carcollection2021.service.CarCollectionService;

@Controller
public class CollectionController {

    @Value("${spring.application.name}")
    private String appName;

    static final String APP_NAME = "appName";
    static final String CARS = "cars";  

    @Autowired
    private CarCollectionService carCollectionService;

    @GetMapping(value = "/")
    public String getHome(Model model) {
        model.addAttribute(APP_NAME, appName);
        return "home";
    }

    @GetMapping(value = "/collection")
    public String getCollectionCar(Model model) {
        List<Car> carList = carCollectionService.getListCar();
        model.addAttribute(CARS, carList);
        model.addAttribute(APP_NAME, appName);
        return "collection";
    }
}
