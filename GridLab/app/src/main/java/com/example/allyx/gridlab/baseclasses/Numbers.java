package com.example.allyx.gridlab.baseclasses;

/**
 * Created by allyx on 5/12/2016.
 */
public class Numbers {
    private String number;
    private int numberTextColor;
    private int numberBackgroundColor;

    public Numbers(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumberTextColor() {
        return numberTextColor;
    }

    public void setNumberTextColor(int numberTextColor) {
        this.numberTextColor = numberTextColor;
    }

    public int getNumberBackgroundColor() {
        return numberBackgroundColor;
    }

    public void setNumberBackgroundColor(int numberBackgroundColor) {
        this.numberBackgroundColor = numberBackgroundColor;
    }

    @Override
    public String toString() {
        return number;
    }
}
