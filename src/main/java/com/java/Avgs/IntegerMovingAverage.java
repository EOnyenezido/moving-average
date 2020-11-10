package com.java.Avgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class implements the MovingAverage interface for Integers to give the moving average of the last N Integers added.
 *
 * This implementation simply uses an array of length N to store the last N integers by position,
 * overwriting the last Integer when a new one is added.
 *
 * It also maintains the sum and count of the Integers so it can simply return the average
 * as an O(1) operation ie. sum / count
 * */
public class IntegerMovingAverage implements MovingAverage<Integer> {
    private int[] window;
    private int count = 0;
    private int position = 0;
    private int sum = 0;

    /**
     * This constructor is initialized with N, the number of previous integers for which the average is to be calculated
     *
     * @param windowSize The number of previous integers for which the average is to be calculated
     * */
    public IntegerMovingAverage(int windowSize) {
        window = new int[windowSize];
    }

    /**
     * This method essentially adds a new Integer to the list of Integer.
     *
     * @param element The Integer to be added to the list.
     */
    @Override
    public void addElement(Integer element) {
        // Keep a count if the last added elements
        if (count < window.length) count++;
        // Keep a sum of the last added N elements
        sum -= window[position];
        sum += element;
        // Add the element at the correct position, overwriting the previous N + 1 element
        window[position] = element;
        position = (position + 1) % window.length;
    }

    /**
     * This method gets an element from the last N added Integers based on the index.
     * <p>
     * It is zero indexed with respect to N, for example after adding 5 Integers (N = 5),
     * to retrieve the 1st Integer added, index = 0, 2nd Integer - index = 1 and so on.
     * <p>
     * When an Integer does not exist at an index, it throws a java.util.NoSuchElementException exception.
     * For example where N = 5, after adding 3 Integers then call get element at index 4
     *
     * @param index The index of the Integer to retrieve
     * @return (Integer) - The requested Integer at that index
     * @throws NoSuchElementException This exception is thrown when an element does not exist at a requested index.
     */
    @Override
    public Integer getElement(int index) throws NoSuchElementException {
        // Element does not exist
        if (index < 0 || index >= window.length || index > count || count == 0) {
            throw new NoSuchElementException("No element exists at index: " + index);
        }

        return count < window.length ? window[index] : window[(position + index) % window.length];
    }
}