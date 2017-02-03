/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Copyright ©2016 Gary F. Pollice
 *******************************************************************************/

package stablesort;

/**
 * This class performs stable sorts on an array of objects.
 *
 * @version Sep 26, 2016
 */
public class StableSorter implements StableSort {
    
    /*
     * @see stablesort.StableSort#stableSort(T)
     */
    @Override
    public <T extends Comparable<T>> T[] stableSort(T... items) {
        mergeSort(items);
        return items;
    }
    
    /**
     * Sort array of elements in ascending order
     *
     * @param items The array element
     */
    private <T extends Comparable<T>> void mergeSort(T... items) {
        mergeSortHelper(items, 0, items.length - 1);
    }
    
    /**
     * Sort elements between start and end inclusively with merge sort
     *
     * @param items The array of source items
     * @param start The index of the start of sub array to be sorted
     * @param end   The end of sub array to be sorted
     */
    private <T extends Comparable<T>> void mergeSortHelper(T[] items, int start, int end) {
        if (isSorted(start, end)) return;
        
        int mid = calcMiddleIndex(start, end);
        
        mergeSortHelper(items, start, mid);
        mergeSortHelper(items, mid + 1, end);
        merge(items, start, mid, end);
    }
    
    /**
     * Merge two sorted sub arrays into a single sorted array
     *
     * @param items The source array
     * @param start The index of the start of left sub array
     * @param mid   The index of the end of the left sub array
     * @param end   The index of of end of right sub array
     */
    private <T extends Comparable<T>> void merge(T[] items, int start, int mid, int end) {
        int leftLength = leftSubArraySize(start, mid);
        int rightLength = rightSubArraySize(mid, end);
        
        T[] leftSubArray = copySubArray(items, start, mid);
        T[] rightSubArray = copySubArray(items, mid + 1, end);
        
        int leftIndex = 0, rightIndex = 0, resIndex = start;
        while (!(isEmpty(leftIndex, leftLength) && isEmpty(rightIndex, rightLength))) {
            if (isEmpty(leftIndex, leftLength))
                copyElement(rightSubArray, rightIndex++, items, resIndex++);
            else if (isEmpty(rightIndex, rightLength))
                copyElement(leftSubArray, leftIndex++, items, resIndex++);
            else if (lessOrEqual(leftSubArray[leftIndex], rightSubArray[rightIndex]))
                copyElement(leftSubArray, leftIndex++, items, resIndex++);
            else copyElement(rightSubArray, rightIndex++, items, resIndex++);
        }
    }
    
    /**
     * Calculate the index of middle element
     *
     * @param start Index of starting element
     * @param end   Index of ending element
     *
     * @return the index of middle element
     */
    private int calcMiddleIndex(int start, int end) {
        return (start + end) / 2;
    }
    
    /**
     * Calculate the size of left sub array
     *
     * @param start The start of parent array
     * @param mid   The middle of parent array
     *
     * @return the size of left sub array
     */
    private int leftSubArraySize(int start, int mid) {
        return mid - start + 1;
    }
    
    /**
     * Calculate the size of right sub array
     *
     * @param start The start of parent array
     * @param mid   The middle of parent array
     *
     * @return the size of right sub array
     */
    private int rightSubArraySize(int start, int mid) {
        return mid - start;
    }
    
    /**
     * Copy elements between start and end into a new array
     *
     * @param src   The source array to copy from
     * @param start The start index of source array
     * @param end   The end index of source array
     *
     * @return a new array containing elements between start and end in the source array
     */
    private <T extends Comparable<T>> T[] copySubArray(T[] src, int start, int end) {
        T[] newArray = (T[]) new Comparable[end - start + 1];
        for (int i = start; i <= end; i++)
            newArray[i - start] = src[i];
        return newArray;
    }
    
    /**
     * Check whether a array is empty
     *
     * @param start The start of the array
     * @param end   The end of the the
     *
     * @return return when the array is empty
     */
    private boolean isEmpty(int start, int end) {
        return start >= end;
    }
    
    /**
     * Compare whether the second element is less than or equals to the first element
     *
     * @param first  The first element
     * @param second The second element
     *
     * @return true if the second element is less than or equals to the first element, false
     * otherwise
     */
    private <T extends Comparable<T>> boolean lessOrEqual(T first, T second) {
        return first.compareTo(second) <= 0;
    }
    
    /**
     * Copy an certain element from source array into destination array at given index
     *
     * @param src       The source  array
     * @param srcIndex  The index of element to copy in the source array
     * @param dest      The destination array
     * @param destIndex The index of element at the destination array
     */
    private <T extends Comparable<T>> void copyElement(T[] src, int srcIndex, T[] dest, int
            destIndex) {
        dest[destIndex] = src[srcIndex];
    }
    
    /**
     * Check whether a given array is sorted
     * @param start The start of the array
     * @param end The end of the array
     * @return true if the array between start and end is sorted, false otherwise
     */
    private boolean isSorted(int start, int end) {
        return end <= start;
    }
}
