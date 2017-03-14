package com.example.aloid.android_current;


import java.util.ArrayList;

/**
 * Created by aloid on 3/8/2017.
 */

public class Utils {
    public static ArrayList<Penguins>fillPenguins(){
        Penguins peng1 = new Penguins("Vasja");
        Penguins peng2 = new Penguins("Petja");
        Penguins peng3 = new Penguins("Fedja");
        Penguins peng4 = new Penguins("Ulric");
        Penguins peng5 = new Penguins("Fred");
        Penguins peng6 = new Penguins("Bob");
        Penguins peng7 = new Penguins("Sam");

        ArrayList<Penguins>pengList = new ArrayList<>();
        pengList.add(peng1);
        pengList.add(peng2);
        pengList.add(peng3);
        pengList.add(peng4);
        pengList.add(peng5);
        pengList.add(peng6);
        pengList.add(peng7);

        return pengList;
    }
}
