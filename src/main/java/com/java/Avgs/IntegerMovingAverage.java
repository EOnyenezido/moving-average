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
}