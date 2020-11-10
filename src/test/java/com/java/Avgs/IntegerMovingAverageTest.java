package com.java.Avgs;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class IntegerMovingAverageTest {

    @Test
    public void shouldBeZeroAverage_WhenNoElementHasBeenAdded() {
        // GIVEN an instantiated IntegerMovingAverage instance
        // WHEN no element has been added
        // THEN the average should be zero

        // Arrange
        IntegerMovingAverage emptyMvAg = new IntegerMovingAverage(5);

        // Act
        double avg = emptyMvAg.getAverage();

        //Assert
        assertEquals(Double.NaN, avg, 0.0);
    }

    @Test
    public void shouldAddElementToInternalArray() {
        // GIVEN an IntegerMovingAverage instance
        // WHEN a single element is added
        // THEN the average should equal the single element

        // Arrange
        IntegerMovingAverage mvAvg = new IntegerMovingAverage(10);

        // Act
        mvAvg.addElement(5);
        double avg = mvAvg.getAverage();

        // Assert
        assertEquals(5, (int) mvAvg.getElement(0));
        assertEquals(5.0, avg, 0.0);
    }
}