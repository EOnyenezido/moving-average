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

    @Test
    public void shouldCorrectlyRetrieveElement_WhenGivenAnIndex() {
        // GIVEN an IntegerMovingAverage instance
        // WHEN elements are added and get the last i element is called
        // THEN it should correct return the last i element

        // Arrange
        IntegerMovingAverage mvAvg = new IntegerMovingAverage(5);

        // Act
        mvAvg.addElement(4);
        mvAvg.addElement(5);
        mvAvg.addElement(-6);
        int elementBeforeFullWindow = mvAvg.getElement(1);
        mvAvg.addElement(12);
        mvAvg.addElement(36);
        int elementWhenFullWindow = mvAvg.getElement(4);
        mvAvg.addElement(74);
        mvAvg.addElement(-8);
        int elementAfterFullWindow = mvAvg.getElement(0);

        // Assert
        // Can retrieve the last i element even when we have not fully added N elements
        assertEquals(5, elementBeforeFullWindow);
        // Can retrieve the last i element when we have fully added N elements
        assertEquals(36, elementWhenFullWindow);
        // Can retrieve the last i element when we have added more elements past N
        assertEquals(-6, elementAfterFullWindow);
    }

    @Test
    public void shouldThrowAnException_WhenGivenAnInvalidIndex() {
        // GIVEN an IntegerMovingAverage instance
        // WHEN get the last i element is called with an invalid index
        // THEN it should throw a NoSuchElementException

        // Arrange
        IntegerMovingAverage mvAvg = new IntegerMovingAverage(10);

        // Act and Assert
        int[] invalidIndexes = new int[] {0, 1, -1, 11};
        for (int index : invalidIndexes) {
            Exception exception = assertThrows(NoSuchElementException.class, () -> mvAvg.getElement(index));

            // Assert
            String expectedMessage = "No element exists at index: " + index;
            String actualMessage = exception.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }
}