package com.example.prac_admin_pos.data;

import com.example.prac_admin_pos.model.User;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<User> userList;

    public Data() {
        userList = new ArrayList<>();
        this.prepareUserData();
    }
    public void prepareUserData() {
        User User = new User("jose", "@jose", "jose", "678");
        userList.add(User);

        User = new User("juan", "@juan", "juan", "876");
        userList.add(User);

        User = new User("mario", "@mario", "mario", "789");
        userList.add(User);

        User = new User("jesus", "@jesus", "jesus", "978");
        userList.add(User);
    }

    public List<User> getUserList() {
        return userList;
    }
}
