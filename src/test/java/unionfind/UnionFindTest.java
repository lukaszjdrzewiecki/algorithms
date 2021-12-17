package unionfind;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UnionFindTest {

    WeightedQuickUnionUF testee;

    @Before
    public void init() {
        testee = new WeightedQuickUnionUF(10);
    }

    @Test
    public void testUnion() {
        testee.union(4, 3);
        testee.union(3, 8);
        testee.union(6, 5);
        testee.union(9, 4);
        testee.union(2, 1);
        assertFalse(testee.connected(0, 7));
        assertTrue(testee.connected(8, 9));
        testee.union(5, 0);
        testee.union(7, 2);
        testee.union(6, 1);
        testee.union(1, 0);
        assertTrue(testee.connected(0, 7));

        System.out.println(Arrays.toString(testee.id));
        System.out.println(Arrays.toString(testee.sz));
    }
}
