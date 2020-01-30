package com.janinc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-29
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.enums.PetTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Person {
    private String name;
    private int age;
    private List<Pet> pets = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void boughtPet(Pet pet){
        pets.add(pet);
    } // boughtPet

    @Override
    public String toString() {

        if (pets.size() == 0) {
            return String.format("%s (%d) owns no pets :(", name, age);
        }
            else {
            if (pets.size() == 1) {
                return String.format("%s (%d) owns the %s: %s", name, age, pets.get(0).getType(), pets.get(0).getName());
            }
            else {
                Map<PetTypes, List<Pet>> groupedPets = (Map<PetTypes, List<Pet>>) pets.stream()
                        .collect(groupingBy(Pet::getType));
                return String.format("%s (%d) owns the animals: %s", name, age,
                        groupedPets
                        .entrySet()
                        .stream()
                        .map(o -> o.getKey() + ": " + o.getValue().stream().map(Pet::getName).collect(Collectors.joining(", ")))
                        .collect(Collectors.joining( "; ")));
            } // else
        } // else
    } // toString
} // class Person