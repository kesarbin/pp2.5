package htmlNenavizhu.controller;

import htmlNenavizhu.config.AppConfig;
import htmlNenavizhu.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import htmlNenavizhu.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private final UserService userService;

    @Autowired
    public CarsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model) {

//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(AppConfig.class);

        //UserService userService = context.getBean(UserService.class);

        List<String> messages = new ArrayList<>();
        List<Car> carsList = userService.listCars();
        for (Car car: carsList){
            messages.add(car.getModel().toString()+"      "+car.getSeries());
        }
        model.addAttribute("messages", messages);
        return "index";
    }

}
