package com.rest_api.Restful_Api_for_SocialMedia.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
//creating the REST Controller to call the REST API methods
@RestController
public class UserResource {
private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }
@GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveOneUser(@PathVariable int id)
    {
        return service.findOneUser(id);
    }
}
