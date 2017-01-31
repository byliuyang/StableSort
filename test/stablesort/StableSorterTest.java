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
    public void sortEmptyArray() {
        Sortable<Integer>[] result = sorter.stableSort(new Sortable[0]);
        assertEquals(0, result.length);
    }
    
    @Test // 2
    public void sortOneElement() {
        final Integer FIRST_INT = 1;
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT);
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(1, result.length);
        assertEquals(FIRST_INT, result[0].getPayload());
        assertEquals(0, result[0].getIndex());
    }
    
    
    @Test // 3
    public void sortTwoSortedElements() throws Exception {
        final Integer FIRST_INT = 1,
                SECOND_INT = 2;
        
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
    public void sortTwoElementInAscendingOrder() throws Exception {
        final Integer FIRST_INT = 2,
                SECOND_INT = 1;
    
        SortableFactory<Integer> sortableFactory = new SortableFactory<>();
        Sortable<Integer>[] sortables = sortableFactory.makeSortableArray(FIRST_INT, SECOND_INT);
        
        Sortable<Integer>[] result = sorter.stableSort(sortables);
        assertEquals(2, result.length);
        assertEquals(SECOND_INT, result[0].getPayload());
        assertEquals(1, result[0].getIndex());
        assertEquals(FIRST_INT, result[1].getPayload());
        assertEquals(0, result[1].getIndex());
    }
}
