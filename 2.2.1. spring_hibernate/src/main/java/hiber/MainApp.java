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

       User user1 = new User("User1", "Lastname6", "user1@Gmail.ru");
       User user2 = new User("User2", "Lastname7", "user2@Gmail.ru");
       User user3 = new User("User3", "Lastname8", "user3@Gmail.ru");
       User user4 = new User("User4", "Lastname9", "user4@Gmail.ru");
       User user5 = new User("User5", "Lastname10", "user5@Gmail.ru");

       Car car1 = new Car("Opel", 1);
       Car car2 = new Car("Mercedes", 200);
       Car car3 = new Car("BMW", 5);
       Car car4 = new Car("Opel", 10);
       Car car5 = new Car("Opel", 1);

       car1.setUser(user1);
       user1.setCar(car1);
       userService.add(user1);

       car2.setUser(user2);
       user2.setCar(car2);
       userService.add(user2);

       car3.setUser(user3);
       user3.setCar(car3);
       userService.add(user3);

       car4.setUser(user4);
       user4.setCar(car4);
       userService.add(user4);

       car5.setUser(user5);
       user5.setCar(car5);
       userService.add(user5);

      List<User> users1 = userService.listUserOwningModelAndSeries("Opel", 1);
      print(users1);
      List<User> users2 = userService.listUserOwningModelAndSeries("Opel", 10);
      print(users2);
      List<User> users3 = userService.listUserOwningModelAndSeries("BMW", 5);
      print(users3);
      List<User> users4 = userService.listUserOwningModelAndSeries("Mercedes", 200);
      print(users4);

      context.close();

   }
   public static void print(List<User> users) {
      for (User user : users) {
          System.out.println("Id = "+user.getId());
          System.out.println("First Name = "+user.getFirstName());
          System.out.println("Last Name = "+user.getLastName());
          System.out.println("Email = "+user.getEmail());
          System.out.println("Car = model: " + user.getCar().getModel() + "  series: " + user.getCar().getSeries());
          System.out.println();
      }
   }
}

