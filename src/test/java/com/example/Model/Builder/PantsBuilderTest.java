package com.example.Model.Builder;

import com.example.Model.BusinessObjects.CEO;
import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.Enums.Color;
import com.example.Model.Enums.Material;
import com.example.Model.Enums.Size;
import com.example.Model.Observer.EventManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PantsBuilderTest {

    private PantsBuilder pantsBuilder;
    private Size size;
    private Color color;
    private Material material;

    @Mock
    private CEO mockCEO;


    @BeforeEach
    public void setUp() {
        pantsBuilder = new PantsBuilder();
        size = Size.MEDIUM;
        color = Color.BLACK;
        material = Material.JEANS;

        mockCEO = mock(CEO.class);
        
    }

    @Test
    void notifyListenersOnEventManagerIsCalledInPantsBuilderCreateClothesMethod(){
        EventManager eventManager = EventManager.getInstance();
        eventManager.addListener(mockCEO);

        PantsBuilder pantsBuilder = new PantsBuilder();

        verify(mockCEO).update("Pants started creation");

    }


    @Test
    void noExceptionInBuild() {

        assertDoesNotThrow(() -> {
            pantsBuilder
                    .addSize(size)
                    .addMaterial(material)
                    .addColor(color)
                    .build();
        });

    }

    @Test
    void buildThrowsExceptionWhenSizeIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addColor(color)
                    .addMaterial(material)
                    .build();
        });

        assertEquals("No size chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenSizeIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addColor(color)
                    .addMaterial(material)
                    .build();
        });


    }

    @Test
    void buildThrowsExceptionWhenMaterialIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(size)
                    .addColor(color)
                    .build();
        });

        assertEquals("No material chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenMaterialIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(size)
                    .addColor(color)
                    .build();
        });

    }

    @Test
    void buildThrowsExceptionWhenColorIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(size)
                    .addMaterial(material)
                    .build();
        });

        assertEquals("No color chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenColorIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(size)
                    .addMaterial(material)
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
    void pantsBuilderShouldReturnInstanceOfPantsWithTheSameAttributes() {
        Pants pants;

        assertInstanceOf(Pants.class,
                pants = (Pants) pantsBuilder
                .addSize(size)
                .addMaterial(material)
                .addColor(color)
                .build());

        assertEquals(size, pants.getSize());
        assertEquals(material, pants.getMaterial());
        assertEquals(color, pants.getColor());
    }

    @Test
    void createClothesMethodShouldReturnInstanceOfPants() {
        assertInstanceOf(Pants.class, pantsBuilder.createClothes());
    }


}