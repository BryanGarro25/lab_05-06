package com.example.prac_admin_pos.model;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class JobApp implements Serializable {
    private String name;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private int postalCode;
    private String country;
    private String emailAddress;
    private int areaCode;
    private String phoneNumber;
    private String position;
    private Calendar date;


    public JobApp(String name, String lastName, String address1, String address2,
                  String city, String state, int postalCode, String country,
                  String emailAddress, int areaCode, String phoneNumber, String position, Calendar date){
        this.name = name;
        this.lastName = lastName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state= state;
        this.postalCode = postalCode;
        this.country = country;
        this.emailAddress = emailAddress;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.date = date;
    }
    public JobApp(){
        this.name = "";
        this.lastName = "";
        this.address1 = "";
        this.address2 = "";
        this.city = "";
        this.state= "";
        this.postalCode = 0;
        this.country = "";
        this.emailAddress = "";
        this.areaCode = 0;
        this.phoneNumber = "";
        this.position = "";
        this.date = null;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JobApp{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", areaCode=" + areaCode +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position='" + position + '\'' +
                ", date=" + date.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobApp)) return false;
        JobApp jobApp = (JobApp) o;
        return getPostalCode() == jobApp.getPostalCode() &&
                getAreaCode() == jobApp.getAreaCode() &&
                getName().equals(jobApp.getName()) &&
                getLastName().equals(jobApp.getLastName()) &&
                getAddress1().equals(jobApp.getAddress1()) &&
                Objects.equals(getAddress2(), jobApp.getAddress2()) &&
                getCity().equals(jobApp.getCity()) &&
                Objects.equals(getState(), jobApp.getState()) &&
                getCountry().equals(jobApp.getCountry()) &&
                getEmailAddress().equals(jobApp.getEmailAddress()) &&
                getPhoneNumber().equals(jobApp.getPhoneNumber()) &&
                getPosition().equals(jobApp.getPosition()) &&
                getDate().equals(jobApp.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getAddress1(), getAddress2(), getCity(), getState(), getPostalCode(), getCountry(), getEmailAddress(), getAreaCode(), getPhoneNumber(), getPosition(), getDate());
    }
}
