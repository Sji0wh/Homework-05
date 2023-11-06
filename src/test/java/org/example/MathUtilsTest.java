package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    MathUtils resultDivision;
    MathUtils resultMultiplying;
    MathUtils resultSquaring;

    @BeforeEach
    void setup(){
        resultDivision = new MathUtils(4.5f, 2.6f);
        resultMultiplying = new MathUtils(4.7f, 5.8f);
    }

    //Parametrized test for integer squaring
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 9})
    public void testSquaring(int a) {
        resultSquaring = new MathUtils(a, 0);
        int squareResult = resultSquaring.squaring();
        assertEquals(a * a, squareResult);
    }

    //Assert that float numbers division passed correctly
    @Test
    public void testFloatingDivision(){
        float divisionResult = resultDivision.divide();
        assertEquals(1.73, divisionResult, 0.001f);
    }

    //Assert that float numbers multiplying passed correctly
    @Test
    public void testMultiplying() {
        float multiplyingResult = resultMultiplying.multiplying();
        assertEquals(27.2f, multiplyingResult, 0.1f);
    }

    //Assert that addition method is working properly
    @Test
    public void testAddSuccessful () {
        MathUtils additionSum = new MathUtils (5,6);
        int sumResult = additionSum.add();
        assertEquals(11,sumResult);
    }

    //Assert that compare method is working properly
    @Test
    public void testBiggerSuccessful (){
        MathUtils resultCompare = new MathUtils(7, 1);
        boolean compareResult = resultCompare.bigger();
        assertTrue(compareResult);
    }

    //Adding two positive integers
    @Test
    public void testAddTwoPositive () {
        MathUtils additionSum = new MathUtils (5,5);
        int sumResult = additionSum.add();
        assertEquals(10,sumResult);
    }

    //Adding zero to positive integer
    @Test
    public void testAddZero () {
        MathUtils additionSum = new MathUtils (5,0);
        int sumResult = additionSum.add();
        assertEquals(5,sumResult);
    }

    //Adding positive integer to negative
    @Test
    public void testAddToNegative () {
        MathUtils additionSum = new MathUtils (-6,5);
        int sumResult = additionSum.add();
        assertEquals(-1,sumResult);
    }

    //Overflow test, assert that correct result appeared
    @Test
    public void testAddOverflow () {
        MathUtils additionSum = new MathUtils (2147483647,1);
        int sumResult = additionSum.add();
        assertEquals(-2147483648,sumResult);
    }

    //Assert that first integer is larger
    @Test
    public void testBiggerFirstLarger (){
        MathUtils resultCompare = new MathUtils(10, 5);
        boolean compareResult = resultCompare.bigger();
        assertTrue(compareResult);
    }

    //Assert that first integer is lesser
    @Test
    public void testBiggerSecondLarger (){
        MathUtils resultCompare = new MathUtils(-5, 5);
        boolean compareResult = resultCompare.bigger();
        assertFalse(compareResult);
    }

    //Assert that result will be false if both integers are equal
    @Test
    public void testBiggerEqual (){
        MathUtils resultCompare = new MathUtils(5, 5);
        boolean compareResult = resultCompare.bigger();
        assertFalse(compareResult);
    }
}