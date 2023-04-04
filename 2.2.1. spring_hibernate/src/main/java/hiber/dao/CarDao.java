package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface CarDao {
    List<User> getUser(String model, int series);
}
