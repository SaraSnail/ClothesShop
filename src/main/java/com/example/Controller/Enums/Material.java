package com.example.Controller.Enums;

public enum Material {
    COTTON(1),POLYESTER(2),JEANS(3);

    int value;

    Material(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Material fromValue(int value) {
        for (Material material : Material.values()) {
            if (material.getValue() == value) {
                return material;
            }
        }
        throw new IllegalArgumentException("Unknown material value");
    }
}
