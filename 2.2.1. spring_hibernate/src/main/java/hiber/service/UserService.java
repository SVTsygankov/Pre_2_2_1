package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    List<User> listUserOwningModelAndSeries(String m, int s);

    User getUser(long id);
}
