package com.example.Controller;

import com.example.Controller.Builder.PantsBuilder;
import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
import com.example.Model.BusinessObjects.Clothes.Pants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    //Mock:a allt!!
    //Test för valda saker och för saker man inte ska kunna välja

    @Test
    void noExceptionInBuild() {
        PantsBuilder builder = new PantsBuilder();
        Pants pants = builder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.JEANS)
                .addColor(Color.BLACK)
                .build();

        assertEquals(Size.MEDIUM, pants.getSize());

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

        assertEquals("No size chosen", exceptionThrown.getMessage());

    }

    @Test
    void catchIfMaterialIsNull() {
        PantsBuilder builder = new PantsBuilder();

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            Pants pants = builder
                    .addSize(Size.MEDIUM)
                    .addColor(Color.BLACK)
                    .build();
        });

        assertEquals("No material chosen", exceptionThrown.getMessage());

    }

    @Test
    void catchIfColorIsNull() {
        PantsBuilder builder = new PantsBuilder();

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            Pants pants = builder
                    .addSize(Size.MEDIUM)
                    .addMaterial(Material.JEANS)
                    .build();
        });

        assertEquals("No color chosen", exceptionThrown.getMessage());

    }


}