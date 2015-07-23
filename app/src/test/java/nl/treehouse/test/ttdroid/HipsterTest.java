package nl.treehouse.test.ttdroid;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by justinhammenga on 23/07/15.
 * Vacatures.nl B.V.
 */
@Config(emulateSdk = 18, reportSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class HipsterTest {

    @Test
    public void testPeel() {
        // given
        Banana banana = new Banana();

        // when
        banana.peel();

        // then
        Assert.assertTrue(banana.isPeeled());
    }
}
