package com.example.Controller;

import com.example.Model.BusinessObjects.Clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    //Mock:a allt!!
    //Test för valda saker och för saker man inte ska kunna välja
    @Test
    void fromValueTwoShouldReturnSizeMedium() {
        PantsBuilder builder = new PantsBuilder();
        Pants pants = builder
                .addSize(Size.fromValue(2))
                .addMaterial(Material.fromValue(1))
                .addColor(Color.fromValue(1))
                .build();

        assertEquals(Size.MEDIUM, pants.getSize());
    }

    @Test
    void fromValueThreeShouldReturnMaterialJeans() {
        PantsBuilder builder = new PantsBuilder();
        Pants pants = builder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.fromValue(3))
                .addColor(Color.BLACK)
                .build();

        assertEquals(Material.JEANS, pants.getMaterial());
    }

    @Test
    void addColor() {
    }

    //Skarp
    @Test
    void catchIfSizeIsNull() {
        PantsBuilder builder = new PantsBuilder();

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            Pants pants = builder
                    .addColor(Color.BLACK)
                    .addMaterial(Material.JEANS)
                    .build();
        });
        assertEquals(exceptionThrown.getMessage(), "No size chosen");
        //Vill testa Builds if=null
    }
}