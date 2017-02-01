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
        // TODO.md Implement this method.
        mergeSort(items);
        return items;
    }
    
    private <T extends Comparable<T>> void mergeSort(T... items) {
        mergeSortHelper(items, 0, items.length - 1);
    }
    
    private <T extends Comparable<T>> void mergeSortHelper(T[] items, int start, int end) {
        if (isSorted(start, end)) return;
        
        int mid = calcMiddleIndex(start, end);
        
        mergeSortHelper(items, start, mid);
        mergeSortHelper(items, mid + 1, end);
        merge(items, start, mid, end);
    }
    
    private <T extends Comparable<T>> void merge(T[] items, int start, int mid,int end) {
        int leftLength = leftSubArraySize(start, mid);
        int rightLength = rightSubArraySize(mid, end);
    
        T[] leftSubArray = copySubArray(items, start, mid);
        T[] rightSubArray = copySubArray(items, mid + 1, end);
    
        int leftIndex = 0, rightIndex = 0, resIndex = 0;
        while (!(isEmpty(leftIndex, leftLength) && isEmpty(rightIndex, rightLength))) {
            if (isEmpty(leftIndex, leftLength))
                copyElement(rightSubArray, rightIndex++, items, resIndex++);
            else if (isEmpty(rightIndex, rightLength))
                copyElement(leftSubArray, leftIndex++, items, resIndex++);
            else if (lessThan(leftSubArray[leftIndex], rightSubArray[rightIndex]))
                copyElement(leftSubArray, leftIndex++, items, resIndex++);
            else copyElement(rightSubArray, rightIndex++, items, resIndex++);
        }
    }
    
    private int calcMiddleIndex(int start, int end) {
        return (start + end) / 2;
    }
    
    private int leftSubArraySize(int start, int mid) {
        return mid - start + 1;
    }
    
    private int rightSubArraySize(int start, int mid) {
        return mid - start;
    }
    
    private <T extends Comparable<T>> T[] copySubArray(T[] src, int start, int end) {
        T[] newArray = (T[]) new Comparable[end - start + 1];
        for (int i = start; i <= end; i++)
            newArray[i - start] = src[i];
        return newArray;
    }
    
    private boolean isEmpty(int index, int length) {
        return index >= length;
    }
    
    private <T extends Comparable<T>> boolean lessThan(T first, T second) {
        return first.compareTo(second) <= 0;
    }
    
    private <T extends Comparable<T>> void copyElement(T[] src, int srcIndex, T[] dest, int
            destIndex) {
        dest[destIndex] = src[srcIndex];
    }
    
    private boolean isSorted(int start, int end) {
        return end <= start;
    }
}
