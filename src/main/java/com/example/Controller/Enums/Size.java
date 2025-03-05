package com.example.Controller.Enums;

public enum Size {
    SMALL(1), MEDIUM(2), LARGE(3);

    int value;

    Size(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Size fromValue(int value){
        for(Size size: Size.values()){
            if(size.getValue() == value){
                return size;
            }
        }
        throw new IllegalArgumentException("Unknown Size value");
    }
}
