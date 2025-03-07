package com.example.Controller.Builder;

import com.example.Controller.Enums.Color;
import com.example.Controller.Enums.Material;
import com.example.Controller.Enums.Size;
import com.example.Model.BusinessObjects.Clothes.Clothes;
import com.example.Model.BusinessObjects.Clothes.Pants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PantsBuilderTest {

    private PantsBuilder pantsBuilder;
    private Pants pants;


    @BeforeEach
    public void setUp() {
        pantsBuilder = new PantsBuilder();
        pants = new Pants();
    }


    @Test
    void noExceptionInBuild() {

        pants = (Pants) pantsBuilder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.JEANS)
                .addColor(Color.BLACK)
                .build();

        assertEquals(Size.MEDIUM, pants.getSize());

    }

    @Test
    void catchIfSizeIsNull() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pants = (Pants) pantsBuilder
                    .addColor(Color.BLACK)
                    .addMaterial(Material.JEANS)
                    .build();
        });

        assertEquals("No size chosen", exceptionThrown.getMessage());

    }

    @Test
    void catchIfMaterialIsNull() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pants = (Pants) pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addColor(Color.BLACK)
                    .build();
        });

        assertEquals("No material chosen", exceptionThrown.getMessage());

    }

    @Test
    void catchIfColorIsNull() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pants = (Pants) pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addMaterial(Material.JEANS)
                    .build();
        });

        assertEquals("No color chosen", exceptionThrown.getMessage());

    }

    @Test
    void createClothesReturnPants() {

        Clothes pants = pantsBuilder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.JEANS)
                .addColor(Color.BLACK)
                .build();

        assertInstanceOf(Pants.class, pants, "Created object should be instance of Pants");

    }



}