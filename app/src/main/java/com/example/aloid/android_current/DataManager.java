package com.example.aloid.android_current;


import java.util.ArrayList;

/**
 * Created by aloid on 3/7/2017.
 */

public class DataManager {

    private ArrayList<Penguins> penguinData;

    private static DataManager instance;

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public DataManager() {
        if (penguinData == null) {
            penguinData = new ArrayList<>();
            penguinData = Utils.fillPenguins();
        }
    }

    public ArrayList<Penguins> getPenguins() {
        return penguinData;
    }

    public void setPenguin(String name) {
        penguinData.add(new Penguins(name));
    }

    public void setCheckPenguin(int i,boolean key){
        penguinData.get(i).setCheck(key);
    }

    public void delPenguin() {
        for(int i=penguinData.size()-1;i>=0;i--){
            if(penguinData.get(i).isCheck()==true){
                penguinData.remove(penguinData.get(i));
            }
        }
    }

    public int findChecked(){
        int count=0;
        for(int i=0;i<penguinData.size();i++){
            if(penguinData.get(i).isCheck()==true)
                count++;
        }
        return count;
    }
    
}