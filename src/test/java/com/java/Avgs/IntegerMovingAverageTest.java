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

    @Test
    public void shouldReturnAllElementsInOrderTheyWereAdded() {
        // GIVEN an IntegerMovingAverage instance
        // WHEN get all elements is called
        // THEN it should return all elements in the order they were added

        // Arrange
        IntegerMovingAverage mvAvg = new IntegerMovingAverage(5);

        // Act
        mvAvg.addElement(4);
        mvAvg.addElement(-92);
        mvAvg.addElement(2834);
        List<Integer> firstThreeElements = mvAvg.getAllElements();
        mvAvg.addElement(12);
        mvAvg.addElement(4);
        List<Integer> firstFiveElements = mvAvg.getAllElements();
        mvAvg.addElement(36);
        mvAvg.addElement(-98);
        mvAvg.addElement(-239);
        List<Integer> nextFiveElements = mvAvg.getAllElements();

        // Assert
        List<Integer> actualFirstThreeElements = Arrays.asList(4, -92, 2834);
        assertEquals(firstThreeElements, actualFirstThreeElements);
        List<Integer> actualFirstFiveElements = Arrays.asList(4, -92, 2834, 12, 4);
        assertEquals(firstFiveElements, actualFirstFiveElements);
        List<Integer> actualNextFiveElements = Arrays.asList(12, 4, 36, -98, -239);
        assertEquals(nextFiveElements, actualNextFiveElements);
    }

    @Test
    public void shouldCorrectlyReturnWindowSize() {
        // GIVEN an IntegerMovingAverage instance
        // WHEN get window size is called
        // THEN the window size should be the same as when initialized

        // Arrange
        int windowSize = 8;
        IntegerMovingAverage mvAvg = new IntegerMovingAverage(windowSize);

        // Act
        int actualWindowSize = mvAvg.getWindowSize();

        // Assert
        assertEquals(windowSize, actualWindowSize);
    }

    @Test
    public void shouldCorrectlyCalculateMovingAverage_WhenSeveralElementsAreAdded() {
        // GIVEN an IntegerMovingAverage instance
        // WHEN several elements are added and get average is called
        // THEN should correctly return the average

        // Arrange
        IntegerMovingAverage mvAvg = new IntegerMovingAverage(5);

        //Act
        // First test number of elements less than window size
        mvAvg.addElement(4);
        mvAvg.addElement(6);
        mvAvg.addElement(93);
        double avgWhenLessThanWindowSize = mvAvg.getAverage();

        // Then test when number of elements are equal to window size
        mvAvg.addElement(74);
        mvAvg.addElement(12);
        double avgWhenEqualToWindowSize = mvAvg.getAverage();

        // Then test when number of elements are greater than window size
        // The average should be that of the last N elements
        mvAvg.addElement(8);
        mvAvg.addElement(4);
        mvAvg.addElement(15);
        mvAvg.addElement(3);
        mvAvg.addElement(6);
        mvAvg.addElement(91);
        mvAvg.addElement(1067);
        double avgWhenGreaterThanWindowSize = mvAvg.getAverage();

        // Assert
        assertEquals(34.33, avgWhenLessThanWindowSize, 0.01);
        assertEquals(37.8, avgWhenEqualToWindowSize, 0.0);
        assertEquals(236.4, avgWhenGreaterThanWindowSize, 0.0);
    }
}