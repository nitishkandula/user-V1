package com.nitish.dao;

import com.nitish.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by nitishkandula on 23/01/17.
 */

public interface UserRepository extends Repository<User, String> {

    List<User> findAll();
    User findById(String id);
    User save(User user);
    void delete(String id);

}
