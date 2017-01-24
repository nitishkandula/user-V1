package com.nitish.service;

import com.nitish.dao.UserRepository;
import com.nitish.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nitishkandula on 23/01/17.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userDAO;

    public User getByUserId(String id) {
        User user = userDAO.findById(id);
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = userDAO.findAll();
        return users;
    }

    public User createUser(User user){
         return userDAO.save(user);

    }

    public User updateUser(User user){
        return userDAO.save(user);

    }

    public void deleteUser(String id){
        userDAO.delete(id);

    }
}
