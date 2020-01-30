package com.janinc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-29
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.enums.Gender;

public class Name {
    private String name;
    private Gender gender;

    public Name(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Name{" + "name: '" + name + "\'" + ", gender: " + gender + '}';
    } // toString
} // class Name
