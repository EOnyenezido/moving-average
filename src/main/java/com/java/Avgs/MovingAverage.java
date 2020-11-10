package com.java.Avgs;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * This interface defines a data structure that provides the moving average of the last N elements added.
 *
 * The implementation should essentially support six functions - allow adding an element, getting an element,
 * getting all N elements, getting the average of the last N elements and getting/changing the value of N,
 * the window of elements to average
 *
 * Generics are used here to allow the implementer choose the data type, whether Integer, Long, Double, Float
 * or some custom data type.
 * */
public interface MovingAverage<T> {
    /**
     * This method essentially adds a new element to the list of elements.
     *
     * @param element The element to be added to the list.
     *                The data type is defined by the implementer.
     * */
    void addElement(T element);

    /**
     * This method gets an element from the last N added elements based on the index.
     *
     * It is zero indexed with respect to N, for example after adding 5 elements (N = 5),
     * to retrieve the 1st element added, index = 0, 2nd element - index = 1 and so on.
     *
     * When an element does not exist at an index, it throws a java.util.NoSuchElementException exception.
     * For example where N = 5, after adding 3 elements then call get element at index 4
     *
     * @param index The index of the element to retrieve
     *
     * @return (Generic) - The requested element at that index
     *
     * @throws NoSuchElementException This exception is thrown when an element does not exist at a requested index.
     * */
    T getElement(int index) throws NoSuchElementException;

    /**
     * This method returns a list of the last N elements added in the order they were added.
     *
     * @return (List(Generic)) - An ordered list of the last N elements added.
     * */
    List<T> getAllElements();

    /**
     * This method computes the moving average of the last N elements.
     *
     * @return (double) - The moving average average of the last N elements.
     * */
    double getAverage();

    /**
     * This method returns the current window size or N.
     *
     * @return (int) - The current window size or N.
     * */
    int getWindowSize();

    /**
     * This method allows for changing the current window size or N.
     *
     * @param newWindowSize The new value of N or the window size.
     *
     * @return (boolean) - Whether the window size was changed successfully.
     * */
    boolean changeWindowSize(int newWindowSize);
}