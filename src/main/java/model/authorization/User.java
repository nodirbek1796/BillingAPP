package model.authorization;

import model.base.BaseModel;

public class User extends BaseModel {

    private String phoneNumber;
    private String password;
    private String email;
    private int age;

    public User() {
    }

    public User(String name, String phoneNumber, String password, String email, int age) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
