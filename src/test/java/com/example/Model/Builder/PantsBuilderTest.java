package com.example.Model.Builder;

import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.Enums.Color;
import com.example.Model.Enums.Material;
import com.example.Model.Enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PantsBuilderTest {

    private PantsBuilder pantsBuilder;


    @BeforeEach
    public void setUp() {
        pantsBuilder = new PantsBuilder();
    }


    @Test
    void noExceptionInBuild() {

        assertDoesNotThrow(() -> {
            pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addMaterial(Material.JEANS)
                    .addColor(Color.BLACK)
                    .build();
        });

    }

    @Test
    void buildThrowsExceptionWhenSizeIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addColor(Color.BLACK)
                    .addMaterial(Material.JEANS)
                    .build();
        });

        assertEquals("No size chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenSizeIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addColor(Color.BLACK)
                    .addMaterial(Material.JEANS)
                    .build();
        });


    }

    @Test
    void buildThrowsExceptionWhenMaterialIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addColor(Color.BLACK)
                    .build();
        });

        assertEquals("No material chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenMaterialIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addColor(Color.BLACK)
                    .build();
        });

    }

    @Test
    void buildThrowsExceptionWhenColorIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addMaterial(Material.JEANS)
                    .build();
        });

        assertEquals("No color chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenColorIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(Size.MEDIUM)
                    .addMaterial(Material.JEANS)
                    .build();
        });

    }

    @Test
    void buildThrowsExceptionWhenNothingIsSelected() {
        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .build();
        });
    }

    @Test
    void pantsBuilderShouldReturnInstanceOfPants() {

        assertInstanceOf(Pants.class, pantsBuilder
                .addSize(Size.MEDIUM)
                .addMaterial(Material.JEANS)
                .addColor(Color.BLACK)
                .build());
    }

    @Test
    void createClothesMethodShouldReturnInstanceOfPants1() {

        assertInstanceOf(Pants.class, pantsBuilder.createClothes());
    }

}