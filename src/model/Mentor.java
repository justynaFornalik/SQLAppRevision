package model;

import dao.MentorDao;

public class Mentor extends Person{

    String nickName;
    String city;
    int favouriteNumber;

    public Mentor(String firstName, String lastName){
        super(firstName, lastName);
    }

    public Mentor(String firstName, String lastName, String nickName, String phoneNumber, String email, String city, int favouriteNumber){
        super(firstName, lastName, phoneNumber, email);
        this.nickName = nickName;
        this.city = city;
        this.favouriteNumber = favouriteNumber;
    }

    @Override
    public String toString(){
        return super.toString() + ", " + nickName + ", " + city + ", " + favouriteNumber;
    }
}
