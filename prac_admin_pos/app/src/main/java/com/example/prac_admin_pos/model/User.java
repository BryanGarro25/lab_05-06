package com.example.prac_admin_pos.model;

public class User {
    private String name;
    private String email;
    private String password;
    private String rol;

    public User(String name, String email, String password, String rol){
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    public User(){
        name = "";
        email = "";
        password = "";
        rol = "";
    }
    public String toString(){
        return "Nombre: "+name + ", Email: "+email+", Password: "+password+", Rol: "+rol;
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
}
