package com.nitish.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonSerializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by nitishkandula on 23/01/17.
 */
@Entity
public class User {

    @Id
    String id ;
    @JsonProperty("first_name")
    @Column(name = "first_name", nullable = true)
    String firstName;
    @JsonProperty("last_name")
    @Column(name = "last_name", nullable = true)
    String lastName;
    @JsonProperty("email")
    @Column(name = "email", nullable = true, unique = true)
    String email;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }
}
