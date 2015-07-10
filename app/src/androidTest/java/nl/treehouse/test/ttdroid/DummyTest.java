package nl.treehouse.test.ttdroid;

import junit.framework.TestCase;

/**
 * Created by justinhammenga on 09/07/15.
 * Vacatures.nl B.V.
 */
public class DummyTest extends TestCase {

    public void testAdd() {
        int result = 1 + 1;
        assertTrue("Add operation fails (Got "+Integer.toString(result)+". Expected 2)", result == 2);
    }

    public void testSubtract() {
        int result = 5 - 1;
        assertTrue("Subtract operation fails (Got "+Integer.toString(result)+". Expected 4)", result == 4);
    }
}
