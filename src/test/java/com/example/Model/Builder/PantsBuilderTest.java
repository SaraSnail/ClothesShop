package com.example.Model.Builder;

import com.example.Model.BusinessObjects.Clothes.Pants;
import com.example.Model.Enums.Color;
import com.example.Model.Enums.Material;
import com.example.Model.Enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PantsBuilderTest {

    private PantsBuilder pantsBuilder;

    @Mock
    private Size mockSize;
    private Material mockMaterial;
    private Color mockColor;
    private Pants mockPants;


    @BeforeEach
    public void setUp() {
        pantsBuilder = new PantsBuilder();
        mockSize = mock(Size.class);
        mockMaterial = mock(Material.class);
        mockColor = mock(Color.class);
        mockPants = mock(Pants.class);
        
    }

    @Test
    void useVerify(){
        String sizeString = String.valueOf(mockSize.getValue());
        verify(mockSize).getValue();
    }

    @Test
    void getSizeMediumWithStub(){
        when(mockPants.getSize()).thenReturn(Size.MEDIUM);
        assertEquals(Size.MEDIUM, mockPants.getSize());
    }


    @Test
    void noExceptionInBuild() {

        assertDoesNotThrow(() -> {
            pantsBuilder
                    .addSize(mockSize)
                    .addMaterial(mockMaterial)
                    .addColor(mockColor)
                    .build();
        });

    }

    @Test
    void buildThrowsExceptionWhenSizeIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addColor(mockColor)
                    .addMaterial(mockMaterial)
                    .build();
        });

        assertEquals("No size chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenSizeIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addColor(mockColor)
                    .addMaterial(mockMaterial)
                    .build();
        });


    }

    @Test
    void buildThrowsExceptionWhenMaterialIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(mockSize)
                    .addColor(mockColor)
                    .build();
        });

        assertEquals("No material chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenMaterialIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(mockSize)
                    .addColor(mockColor)
                    .build();
        });

    }

    @Test
    void buildThrowsExceptionWhenColorIsNullMessageCorrect() {

        RuntimeException exceptionThrown = assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(mockSize)
                    .addMaterial(mockMaterial)
                    .build();
        });

        assertEquals("No color chosen", exceptionThrown.getMessage());

    }

    @Test
    void buildThrowsExceptionWhenColorIsNull() {

        assertThrows(RuntimeException.class, () -> {
            pantsBuilder
                    .addSize(mockSize)
                    .addMaterial(mockMaterial)
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
                .addSize(mockSize)
                .addMaterial(mockMaterial)
                .addColor(mockColor)
                .build());
    }

    @Test
    void createClothesMethodShouldReturnInstanceOfPants1() {

        assertInstanceOf(Pants.class, pantsBuilder.createClothes());
    }

}