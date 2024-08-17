package com.rest_api.Restful_Api_for_SocialMedia.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
        User savedUser=service.saveUser(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)
    {
        service.deleteUser(id);
    }
}
