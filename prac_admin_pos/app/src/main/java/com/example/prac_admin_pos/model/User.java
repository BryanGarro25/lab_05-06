package com.example.prac_admin_pos.model;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String name;
    private String email;
    private String password;
    private String rol;

    public User(String id,String name, String email, String password, String rol){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    public User(){
        id="";
        name = "";
        email = "";
        password = "";
        rol = "";
    }
    public String toString(){
        return "Id: "+id+", Nombre: "+name + ", Email: "+email+", Password: "+password+", Rol: "+rol;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRol() {
        return rol;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }
}
