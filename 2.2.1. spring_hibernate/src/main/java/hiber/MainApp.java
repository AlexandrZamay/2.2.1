package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);


      userService.add(new User(new Car("Bugatti", 9000) ,"User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User(new Car("Lada", 666),"User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User(new Car("Mazda", 8),"User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User(new Car("TolkoNeBMW", 3228), "User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      List<User> usersWithCars = carService.getUser("Mazda", 8);
      System.out.println(usersWithCars.get(0).getId() + " " + usersWithCars.get(0).getFirstName() + " " + usersWithCars.get(0).getLastName());

      context.close();
   }
}
