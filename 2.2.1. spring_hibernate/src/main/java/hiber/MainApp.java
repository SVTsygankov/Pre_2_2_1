package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      //userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      //userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      //userService.add(new User("User5", "Lastname5", "user5@mail.ru"));
/*
       User user1 = new User("User1", "Lastname1", "user1@mail.ru");
       Car car = new Car("Opel", 1);
       user1.setCar(car);
       userService.add(user1);
*/
      User user1 = userService.getUser(1);
      Car car1 = new Car("Mercedes",200);
      user1.setCar(car1);
/*
      User user2 = userService.getUser(2);
      Car car2 = new Car("Opel",10);
      user2.setCar(car2);
      User user3 = userService.getUser(3);
      Car car3 = new Car("Mercedes",200);
      user3.setCar(car3);
      User user4 = userService.getUser(4);
      Car car4 = new Car("BMW",5);
      user4.setCar(car4);
      User user5 = userService.getUser(5);
      Car car5 = new Car("Opel",1);
      user5.setCar(car5);
*/
      List<User> users = userService.listUsers();
/*
   //   List<User> users = userService.listUserOwningModelAndSeries("Opel", 1);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();

         System.out.println(user.getCar());
      }
*/
      System.out.println("Длина списка:" + users.size());
      if(users.size() == 0) System.out.println("У пользователей нет таких авто.");

      context.close();
   }
}
