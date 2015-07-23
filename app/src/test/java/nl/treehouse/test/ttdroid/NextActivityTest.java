package nl.treehouse.test.ttdroid;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

/**
 * Created by justinhammenga on 23/07/15.
 * Vacatures.nl B.V.
 */
@Config(emulateSdk = 18, reportSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class NextActivityTest {

    private ActivityController controller;

    @Before
    public void setUp() throws Exception {
        controller = Robolectric.buildActivity(NextActivity.class).create().start();
    }

    @Test
    public void testOnCreate() {
        // given
        NextActivity activity = (NextActivity) controller.get();
        Assert.assertNotNull("Did not create activity", activity);

        // when
        // Activity is created (setup)

        // then
        Assert.assertNotNull("Did not find the proper view", activity.findViewById(R.id.next_activity_view));
    }
}
