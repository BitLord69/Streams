package com.janinc.enums;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-29
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

public enum PetTypes {
    DOG("Dog"),
    CAT( "Cat"),
    HAMSTER("Hamster"),
    PARROT("Parrot"),
    RAT("Rat");

    private final String name;

    PetTypes(String name) {
        this.name = name;
    }

    public int getSize(){
        return this.getSize();
    } // getSize

    @Override
    public String toString() {
        return name;
    }
}
