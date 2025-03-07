package com.example.Controller.Enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {


    @Mock
    private Size size;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getValueShouldReturnCorrectValue(){
        size = Size.SMALL;
        assertEquals(1, size.getValue());
    }


    @Test
    void valueOfOneShouldReturnSmall(){
        size = Size.fromValue(1);
        assertEquals(Size.SMALL,size);
    }

    @Test
    void valueFourShouldReturnIllegalArgumentException(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                size = Size.fromValue(4));

        assertEquals("Unknown Size value", exception.getMessage());

    }
}