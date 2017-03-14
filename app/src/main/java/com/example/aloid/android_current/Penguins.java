package com.example.aloid.android_current;

/**
 * Created by aloid on 3/10/2017.
 */

public class Penguins {
    private String name;
    private boolean check;

    public Penguins(String name, boolean check) {
        this.name = name;
        this.check = check;
    }

    public Penguins(String name) {
        this.name = name;
        this.check = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
