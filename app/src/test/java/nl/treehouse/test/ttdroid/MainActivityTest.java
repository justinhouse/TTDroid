package nl.treehouse.test.ttdroid;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

/**
 * Created by justinhammenga on 23/07/15.
 * Vacatures.nl B.V.
 */
@Config(emulateSdk = 18, reportSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private ActivityController controller;

    @Before
    public void setUp() throws Exception {
        controller = Robolectric.buildActivity(MainActivity.class).create().start();
    }

    @Test
    public void testOnCreate() {
        // given
        MainActivity activity = (MainActivity) controller.get();
        Assert.assertNotNull("Did not create activity", activity);

        // when
        // Activity is creaeted (setup)

        // then
        Assert.assertNotNull("Did not find the proper view", activity.findViewById(R.id.welcome_text));
    }

    @Test
    public void testChangeText() {
        // given
        MainActivity activity = (MainActivity) controller.get();
        Button button = (Button) activity.findViewById(R.id.action_button);

        // when
        button.performClick();

        // when
        Assert.assertEquals("Text is not as expected.", "We rock!", activity.getText());
    }

    @Test
    public void testWillMoveToNextActivity() {
        // given
        MainActivity activity = (MainActivity) controller.get();
        ShadowActivity shadowActivity = Robolectric.shadowOf(activity);
        Button button = (Button) activity.findViewById(R.id.next_button);


        // when
        button.performClick();

        // then
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        Assert.assertEquals(startedIntent.getComponent().getClassName(), NextActivity.class.getName());
    }

    @Test
    public void testCounter() {
        // given
        MainActivity activity = new MainActivity();
        int counter = activity.getCounter();

        // when
        activity.addToCounter(2);
        int newCounter = activity.getCounter();

        // then
        Assert.assertEquals(counter + 2, newCounter);

        // when
        activity.addToCounter(-2);
        int newCounter2 = activity.getCounter();

        // then
        Assert.assertEquals(counter, newCounter2);
    }

    @Test
    public void testDemo() {
        Assert.assertTrue(true);
    }
}
