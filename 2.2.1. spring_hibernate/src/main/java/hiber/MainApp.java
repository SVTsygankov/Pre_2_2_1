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

   //   userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
   //   userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
   //   userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
   //   userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

   //     User user1 = new User("User5", "Lastname4", "user4@mail.ru");
   //     Car car = new Car("Opel", 1);
   //     user1.setCar(car);
   //     userService.add(user1);


      List<User> users = userService.listUserOwningModelAndSeries("Opel", 1);
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();

         System.out.println(user.getCar());
      }
      System.out.println("Длина списка:" + users.size());
      if(users.size() == 0) System.out.println("У пользователей нет таких авто.");

      context.close();
   }
}
