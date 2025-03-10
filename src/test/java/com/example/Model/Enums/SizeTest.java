package com.example.Model.Enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SizeTest {

    private Size size;


    @Test
    void valueSmallShouldHaveIntegerValueOne(){
        size = Size.SMALL;
        assertEquals(1, size.getValue());
    }


    @Test
    void valueOfOneShouldReturnSmall(){
        size = Size.fromValue(1);
        assertEquals(Size.SMALL,size);
    }

    @Test
    void valueMediumShouldHaveIntegerValueTwo(){
        size = Size.MEDIUM;
        assertEquals(2, size.getValue());
    }


    @Test
    void valueOfTwoShouldReturnMedium(){
        size = Size.fromValue(2);
        assertEquals(Size.MEDIUM,size);
    }

    @Test
    void valueLargeShouldHaveIntegerValueThree(){
        size = Size.LARGE;
        assertEquals(3, size.getValue());
    }


    @Test
    void valueOfThreeShouldReturnLarge(){
        size = Size.fromValue(3);
        assertEquals(Size.LARGE,size);
    }

    @Test
    void fromValueFourForASizeShouldReturnIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () ->
                size = Size.fromValue(4));

    }

    @Test
    void fromValueFourForASizeShouldReturnIllegalArgumentExceptionCorrectMessage(){
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                size = Size.fromValue(4));

        assertEquals("Unknown Size value", exception.getMessage());

    }

}