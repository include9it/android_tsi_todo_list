package com.example.aloid.android_current;

import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by aloid on 3/7/2017.
 */

public class DataManager {

    private ArrayList<String> nameList;

    private ArrayList<String> utils(){
        nameList.add("Petja");
        nameList.add("Vasja");
        nameList.add("Pupkin");
        nameList.add("Vasichkin");
        nameList.add("Shlupkin");
        nameList.add("Kepkin");


        return nameList;
    }

    private static DataManager instance;

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public DataManager() {
        if (nameList==null){
            nameList = new ArrayList<>();
            nameList = utils();
        }
    }


    public ArrayList<String> getNames() {
        return nameList;
    }

    public void setName(String name){
        nameList.add(name);
    }


}
