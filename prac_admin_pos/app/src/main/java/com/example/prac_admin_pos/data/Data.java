package com.example.prac_admin_pos.data;

import com.example.prac_admin_pos.model.JobApp;
import com.example.prac_admin_pos.model.User;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Data {
    private List<User> userList;
    private List<JobApp> jobApps;
    public Data() {
        userList = new ArrayList<>();
        this.jobApps = new ArrayList<>();
        this.prepareUserData();
        this.prepareJobApp();
    }
    public void prepareUserData() {
        User User = new User("1","jose", "@jose", "jose", "678");
        userList.add(User);

        User = new User("2","juan", "@juan", "juan", "876");
        userList.add(User);

        User = new User("3","mario", "@mario", "mario", "789");
        userList.add(User);

        User = new User("4","jesus", "@jesus", "jesus", "978");
        userList.add(User);
    }
    private void prepareJobApp(){
        JobApp jobApp1 = new JobApp("Josue", "Cespedes", "Alajuela",
                "Palmares","Santiago", "", 20704, "Costa Rica",
                "josue.cespedes19@gmail.com", 506,
                "86605613", "Senior Developer", "04/29/2020");
        this.jobApps.add(jobApp1);
    }
    public List<User> getUserList() {
        return userList;
    }
    public List<JobApp> getJobApps(){ return  this.jobApps;}
}
