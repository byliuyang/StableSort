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

import org.junit.Before;
import org.junit.Test;
import util.Sortable;
import util.SortableFactory;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for StableSorter.
 *
 * @version Sep 26, 2016
 */
public class StableSorterTest {
    private SortableFactory<Integer> iFactory = null;
    private StableSorter             sorter   = null;
    
    @Before
    public void setup() {
        iFactory = new SortableFactory<>();
        sorter = new StableSorter();
    }
    
    @Test // 1
    public void sortEmptyArrayTest() {
        Sortable<Integer>[] result = sorter.stableSort(new Sortable[0]);
        assertEquals(0, result.length);
    }
    
    @Test // 2
    public void sortOneNumberTest() {
        final Integer FIRST_INT = 1;
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT);
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(1, result.length);
        assertEquals(FIRST_INT, result[0].getPayload());
        assertEquals(0, result[0].getIndex());
    }
    
    
    @Test // 3
    public void sortTwoSortedNumbersTest() throws Exception {
        final Integer FIRST_INT = 1, SECOND_INT = 2;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(2, result.length);
        assertEquals(new Integer(1), result[0].getPayload());
        assertEquals(0, result[0].getIndex());
        assertEquals(new Integer(2), result[1].getPayload());
        assertEquals(1, result[1].getIndex());
    }
    
    @Test // 4
    public void sortTwoNumbersInAscendingOrderTest() throws Exception {
        final Integer FIRST_INT = 2, SECOND_INT = 1;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(2, result.length);
        assertEquals(SECOND_INT, result[0].getPayload());
        assertEquals(1, result[0].getIndex());
        assertEquals(FIRST_INT, result[1].getPayload());
        assertEquals(0, result[1].getIndex());
    }
    
    @Test // 5
    public void sortThreeNumbersTest() throws Exception {
        final Integer FIRST_INT = 3, SECOND_INT = 2, THIRD_INT = 1;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT,
                                                                          THIRD_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(3, result.length);
        assertEquals(THIRD_INT, result[0].getPayload());
        assertEquals(2, result[0].getIndex());
        assertEquals(SECOND_INT, result[1].getPayload());
        assertEquals(1, result[1].getIndex());
        assertEquals(FIRST_INT, result[2].getPayload());
        assertEquals(0, result[2].getIndex());
    }
    
    @Test // 6
    public void stableSortThreeNumbersTest() throws Exception {
        final Integer FIRST_INT = 4, SECOND_INT = 1, THIRD_INT = 4;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT,
                                                                          THIRD_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(3, result.length);
        assertEquals(SECOND_INT, result[0].getPayload());
        assertEquals(1, result[0].getIndex());
        assertEquals(FIRST_INT, result[1].getPayload());
        assertEquals(0, result[1].getIndex());
        assertEquals(THIRD_INT, result[2].getPayload());
        assertEquals(2, result[2].getIndex());
    }
    
    @Test // 7
    public void stableSortThreeEqualNumbersTest() throws Exception {
        final Integer FIRST_INT = 2, SECOND_INT = 2, THIRD_INT = 2;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT,
                                                                          THIRD_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(3, result.length);
        assertEquals(FIRST_INT, result[0].getPayload());
        assertEquals(0, result[0].getIndex());
        assertEquals(SECOND_INT, result[1].getPayload());
        assertEquals(1, result[1].getIndex());
        assertEquals(THIRD_INT, result[2].getPayload());
        assertEquals(2, result[2].getIndex());
    }
    
    @Test // 8
    public void stableSortTwoEqualNumbersHeadTest() throws Exception {
        final Integer FIRST_INT = 6, SECOND_INT = 6, THIRD_INT = 5;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT,
                                                                          THIRD_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(3, result.length);
        assertEquals(THIRD_INT, result[0].getPayload());
        assertEquals(2, result[0].getIndex());
        assertEquals(FIRST_INT, result[1].getPayload());
        assertEquals(0, result[1].getIndex());
        assertEquals(SECOND_INT, result[2].getPayload());
        assertEquals(1, result[2].getIndex());
    }
    
    @Test // 9
    public void stableSortTwoEqualNumbersBackTest() throws Exception {
        final Integer FIRST_INT = 8, SECOND_INT = 2, THIRD_INT = 2;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT,
                                                                          THIRD_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(3, result.length);
        assertEquals(SECOND_INT, result[0].getPayload());
        assertEquals(1, result[0].getIndex());
        assertEquals(THIRD_INT, result[1].getPayload());
        assertEquals(2, result[1].getIndex());
        assertEquals(FIRST_INT, result[2].getPayload());
        assertEquals(0, result[2].getIndex());
    }
    
    @Test // 10
    public void stableSortFourNumbersTwoEqualKeysTest() throws Exception {
        final Integer FIRST_INT = 7, SECOND_INT = 5, THIRD_INT = 4, FORTH_INT = 5;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT,
                                                                          THIRD_INT, FORTH_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(4, result.length);
        assertEquals(THIRD_INT, result[0].getPayload());
        assertEquals(2, result[0].getIndex());
        assertEquals(SECOND_INT, result[1].getPayload());
        assertEquals(1, result[1].getIndex());
        assertEquals(FORTH_INT, result[2].getPayload());
        assertEquals(3, result[2].getIndex());
        assertEquals(FIRST_INT, result[3].getPayload());
        assertEquals(0, result[3].getIndex());
    }
    
    @Test // 11
    public void stableSortFiveNumbersTwoPairsTest() throws Exception {
        final Integer FIRST_INT = 5, SECOND_INT = 3, THIRD_INT = 5, FORTH_INT = 4, FIFTH_INT = 3;
        
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT,
                                                                          THIRD_INT, FORTH_INT,
                                                                          FIFTH_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(5, result.length);
        assertEquals(SECOND_INT, result[0].getPayload());
        assertEquals(1, result[0].getIndex());
        assertEquals(FIFTH_INT, result[1].getPayload());
        assertEquals(4, result[1].getIndex());
        assertEquals(FORTH_INT, result[2].getPayload());
        assertEquals(3, result[2].getIndex());
        assertEquals(FIRST_INT, result[3].getPayload());
        assertEquals(0, result[3].getIndex());
        assertEquals(THIRD_INT, result[4].getPayload());
        assertEquals(2, result[4].getIndex());
    }
}
