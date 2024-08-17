package com.rest_api.Restful_Api_for_SocialMedia.User;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
// creating the Data Access Object servcie for User class to perform CRUD Operation.
@Component
public class UserDaoService {
    static int count=0;
    private static List<User> users=new ArrayList<>();
    static {
        users.add(new User(++count,"Umer", LocalDate.now().minusYears(31)));
        users.add(new User(++count,"Rabia", LocalDate.now().minusYears(27)));
        users.add(new User(++count,"Arsal", LocalDate.now().minusYears(4)));
        users.add(new User(++count,"Aariz", LocalDate.now().minusYears(1)));
    }
    public List<User> findAll()
    {
            return users;
    }
    public User findOneUser(int id)
    {
        Predicate<? super User> predicate=user -> user.getId()==id;
        return users.stream()
                .filter(predicate)
                .findFirst()
                        .orElse(null);

    }
    public User saveUser(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }
    public User deleteUser(int id) {
        return users.remove(id);
    }
}
