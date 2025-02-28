package com.example.Controller;

public enum Color {
    BLACK(1), WHITE(2), BLUE(3);

    int value;

    Color(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static Color fromValue(int value) {
        for(Color c : Color.values()) {
            if(c.getValue() == value) {
                return c;
            }
        }
        throw new IllegalArgumentException("Unknown color value");
    }
}
