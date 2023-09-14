package hiber;

import hiber.config.AppConfig;
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

      List<User> users1 = userService.listUserOwningModelAndSeries("Opel", 1);
      print(users1);
      List<User> users2 = userService.listUserOwningModelAndSeries("Opel", 10);
      print(users2);
      List<User> users3 = userService.listUserOwningModelAndSeries("BMW", 5);
      print(users3);
      List<User> users4 = userService.listUserOwningModelAndSeries("Mercedes", 200);
      print(users4);
      List<User> users5 = userService.listUserOwningModelAndSeries("Mazda", 5);
      print(users5);

      context.close();
   }
   public static void print(List<User> users) {
      for (User user : users) {
         System.out.println("User  = " + user);
         System.out.println("Car   = " + user.getCar());
      }

      System.out.println("Длина списка:" + users.size());
      if(users.size() == 0) System.out.println("У пользователей нет таких авто.");
      System.out.println();
   }
}
