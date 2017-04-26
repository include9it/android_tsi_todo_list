package com.example.aloid.android_current.managers;



import com.example.aloid.android_current.models.Penguins;
import com.example.aloid.android_current.tools.Utils;

import java.util.ArrayList;

/**
 * Created by aloid on 3/7/2017.
 */

public class DataManager {

    private float penguinSize;

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
            penguinSize = penguinData.size();
        }
        dataTools();
    }

    public ArrayList<Penguins> getPenguins() {
        return penguinData;
    }

    public void setPenguin(String name) {
        penguinData.add(new Penguins(name));
    }

    public void setPenguinArray(ArrayList<Penguins>penguinData){
        this.penguinData = penguinData;
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

    public void delDescription(int position){
        if(penguinData.get(position).getDescription()!=null)
        penguinData.get(position).setDescription(null);
    }

    public void changeDescription(int position, String note){
        penguinData.get(position).setDescription(note);
    }

    public void dataTools(){
        if(penguinSize < penguinData.size() || penguinSize > penguinData.size()){
            
        }
        penguinSize = penguinData.size();
    }



}