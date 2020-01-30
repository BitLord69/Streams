package com.janinc;

/*
Programmerat av Jan-Erik "Janis" Karlsson 2020-01-29
Programmering i Java EMMJUH19, EC-Utbildning
CopyLeft 2020 - JanInc
*/

import com.janinc.enums.Gender;
import com.janinc.enums.PetTypes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameGenerator {

    private static NameGenerator mInstance;
    private static final String FILE_NAME = "pet-names-4.txt";

    private List<Name> namesAvailable;
    private List<Name> namesOriginal;

    private NameGenerator() {
        readNamesFile();
    } // PetNameGenerator

    public void readNamesFile(){
        List<String> wordsList;
        Path path = Paths.get(FILE_NAME);

        namesOriginal = new ArrayList<>();

        try {
            wordsList = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        namesOriginal = Stream.of(wordsList.toString().split(","))
                .flatMap(o -> {
                    String s = o.replace("\"", "").replace("[", "").replace("]", "");
                    String[] pair = s.split("\\d+. ");
                    return Stream.of(new Name(pair[1].trim(), Gender.MALE), new Name(pair[2].trim(), Gender.FEMALE));
                })
                .collect(Collectors.toList());

        namesAvailable = new ArrayList<>(namesOriginal);
    } // readNamesFile

    public Pet getPetName(){
        int petNum = (int)(Math.random() * namesAvailable.size());
        Name name = namesAvailable.get(petNum);

        var pettypes = PetTypes.values();
        Pet pet = new Pet(name, pettypes[(int)(Math.random() * pettypes.length)]);

        namesAvailable.remove(name);
        return pet;
    } // getPetName

    public Name getHumanName(){
        int name = (int)(Math.random() * namesOriginal.size());
        return namesOriginal.get(name);
    } // getHumanName

    public static NameGenerator getInstance() {
        if (mInstance == null) {
            mInstance = new NameGenerator();
        }
        return mInstance;
    } // getInstance
} // class NameGenerator
