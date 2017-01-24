package com.nitish.controllers;

import com.nitish.domain.User;
import com.nitish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Created by nitishkandula on 23/01/17.
 */
@RestController
@RequestMapping("/user/v1")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getUserByUId(@PathVariable String id) {
        System.out.println("The id is"+id);
        User user = userService.getByUserId(id);
        return user;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping( method = RequestMethod.POST , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createUser(@RequestBody User user) {
        user.setId(String.valueOf(UUID.randomUUID()));
        System.out.println("POST -----> "+user.getFirstName()+" "+user.getLastName());
        return userService.createUser(user);
    }

    @RequestMapping( method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
    public Object updateUser(@RequestBody User user) {
        System.out.println("PUT -----> "+user.getFirstName()+" "+user.getLastName());
        return userService.updateUser(user);
    }

    @RequestMapping( path="/{id}" , method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id) {
        System.out.println("DELETE -----> "+id);
        userService.deleteUser(id);

    }

}
