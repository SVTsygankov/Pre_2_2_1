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

      List<User> users = userService.listUserOwningModelAndSeries("Opel", 10);

      for (User user : users) {
         System.out.println("User  = " + user);
         System.out.println("Car   = " + user.getCar());
      }

      System.out.println("Длина списка:" + users.size());
      if(users.size() == 0) System.out.println("У пользователей нет таких авто.");

      context.close();
   }
}
