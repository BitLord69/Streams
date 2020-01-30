package com.janinc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-29
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static final int MAX_SHOPPERS = 20;
    private static final int MAX_PETS_PER_CUSTOMER = 5;

    private PetStore store;
    private List<Person> shoppers = new ArrayList<>();

    public Program(){
        store = new PetStore();
        createShoppers();

        System.out.println("People with pets:");
        shoppers.stream().filter(p -> p.getPets().size() > 0).forEach(System.out::println);

        System.out.println("\nPeople without pets:");
        shoppers.stream().filter(p -> p.getPets().size() == 0).forEach(System.out::println);
    } // Program

    private void createShoppers() {
        List<Person> temp = new ArrayList<>();

        for (int i = 0; i < MAX_SHOPPERS; i++) {
            Name name = NameGenerator.getInstance().getHumanName();
            Person p = new Person(name.getName(), (int)(Math.random() * 60 + 10));
            temp.add(p);
            buyAnimals(p);
        } // for i...

        shoppers = temp.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
    } // createShoppers

    private void buyAnimals(Person p) {
        for (int i = 0; i < (int)(Math.random() * MAX_PETS_PER_CUSTOMER); i++) {
            p.boughtPet(store.buy());
        } // for i...
    } // buyAnimals
} // class Program
