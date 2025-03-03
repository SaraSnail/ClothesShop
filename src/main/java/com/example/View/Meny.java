package com.example.View;

import com.example.Controller.Color;
import com.example.Controller.Material;
import com.example.Controller.Size;
import com.example.Model.BusinessObjects.CEO;

public class Meny {
    private static String[] sizes = {String.valueOf(Size.fromValue(1)),String.valueOf(Size.fromValue(2)),String.valueOf(Size.fromValue(3))};
    private static String[] materials = {String.valueOf(Material.fromValue(1)),String.valueOf(Material.fromValue(2)),String.valueOf(Material.fromValue(3))};
    private static String[] colors = {String.valueOf(Color.fromValue(1)),String.valueOf(Color.fromValue(2)),String.valueOf(Color.fromValue(3))};

    public static void main(String[] args) {
        CEO ceo = new CEO();
    }
}
