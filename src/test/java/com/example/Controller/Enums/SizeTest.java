package com.example.Controller.Enums;

import com.example.Controller.Builder.PantsBuilder;
import com.example.Model.BusinessObjects.Clothes.Pants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {
    //Skriva test för denna istället?

    private PantsBuilder builder;
    private Pants pants;

    @BeforeEach
    public void setUp() {
        builder = new PantsBuilder();
        pants = new Pants();
    }

    @Test
    void getValueMediumIfSizeIsMedium() {

        pants = (Pants) builder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.COTTON)
                .addColor(Color.BLACK)
                .build();

        assertEquals(Size.MEDIUM, pants.getSize());
    }

    @Test
    void fromValueTwoShouldReturnMedium() {

        pants = (Pants) builder
                .addSize(Size.fromValue(2))
                .addMaterial(Material.COTTON)
                .addColor(Color.BLACK)
                .build();

        assertEquals(Size.MEDIUM, pants.getSize());
    }

    @Test
    void fromValueFourShouldReturnIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                builder.addSize(Size.fromValue(4)));


        assertEquals("Unknown Size value", exception.getMessage());
    }

}