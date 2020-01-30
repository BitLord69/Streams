package com.janinc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-29
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    public static final int MAX_PETS_IN_STORE = 100;

    List<Pet> pets = new ArrayList<>();

    public PetStore(){
        for (int i = 0; i < MAX_PETS_IN_STORE; i++) {
            pets.add(NameGenerator.getInstance().getPetName());
        } // for i...
    } // PetStore

    public Pet buy(){
        int petNum = (int)(Math.random() * pets.size());
        return pets.remove(petNum);
    } // buyPet
} // class PetStore
