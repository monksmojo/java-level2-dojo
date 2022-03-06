package com.im;

import healthycoderapp.BMICalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FirstTest {
    private First firstObj;

    @BeforeEach
    void setup() {
        firstObj = new First();
    }

    @Test
        //public String replaceSubString
    void should_ReturnNewString_When_MainStringContainsSubString() {
        //given
        String mainString = "to infinity and beyond";
        String subString = "infinity";
        String replacementString = "space";
        String expectedString = "to space and beyond";
        //when
        String resultedString = firstObj.replaceSubString(mainString, subString, replacementString);
        //then
        assertEquals(resultedString, expectedString);
    }

    @Test
        // for public String replaceSubString
    void should_ReturnMainString_When_MainStringNotContainsSubString() {
        //given
        String mainString = "to infinity and beyond";
        String subString = "space";
        String replacementString = "mars";
        //when
        String resultedString = firstObj.replaceSubString(mainString, subString, replacementString);
        //then
        assertEquals(resultedString, mainString);
    }

    @Test
        // for public List<Integer> filterEvenElements(List<Integer> list)
    void should_ReturnOddList_When_ListEvenElements() {
        //given
        List<Integer> actual = new ArrayList(Arrays.asList(3, 4, 5, 6, 8, 10));
        List<Integer> expected = new ArrayList(Arrays.asList(3, 5));
        //when
        actual = firstObj.filterEvenElements(actual);
        //then
        assertEquals(expected, actual);
    }


    @Test
        //BigDecimal calculateAverage(List<BigDecimal> values)
    void should_ReturnCorrectAverage_when_ListIsNotEmpty() {
        //given
        List<BigDecimal> deci = new ArrayList<>();
        deci.add(BigDecimal.valueOf(20.10));
        deci.add(BigDecimal.valueOf(50.70));
        deci.add(BigDecimal.valueOf(10.20));
        BigDecimal expected = BigDecimal.valueOf(27.0);
        //when
        BigDecimal actual = firstObj.calculateAverage(deci);
        //then
        assertEquals(expected, actual);
    }


    @Test
        //public BigDecimal calculateAverage(List<BigDecimal> values)
    void should_ThrowException_when_ListIsEmpty() {
        //given
        List<BigDecimal> valueList = new ArrayList<>();
        //when
        Executable executable = () -> firstObj.calculateAverage(valueList);
        //then
        assertThrows(RuntimeException.class, executable);
    }

    @Test
        // for public Boolean isPallindrome(String origString)
    void should_ReturnTrue_When_IsPalindrome() {
        //given
        String originalString = "naman";
        //when
        boolean isPal = firstObj.isPallindrome(originalString);
        //then
        assertTrue(isPal);
    }

    @Test
        // public Boolean isPallindrome(String origString)
    void should_ReturnFalse_When_IsNotPalindrome() {
        //given
        String originalString = "qwerty";
        //when
        boolean isPal = firstObj.isPallindrome(originalString);
        //then
        assertFalse(isPal);
    }
}