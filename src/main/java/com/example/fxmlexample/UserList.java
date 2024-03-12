package com.example.fxmlexample;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserList {
    public ArrayList<User> users;
    UserList(){
        users = new ArrayList<>();
        users.add(new User("paul","abellana"));
        users.add(new User("francis","chavez"));
        users.add(new User("nina","catubig"));
    }
}
