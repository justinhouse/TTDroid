package nl.treehouse.test.ttdroid;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerActions.openDrawer;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by justinhammenga on 22/07/15.
 * Vacatures.nl B.V.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        Intent intent = new Intent();
        intent.putExtra("activityNeedsData", false);

        setActivityIntent(intent);
        activity = getActivity();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testPreconditions() {
        assertNotNull("mActivity is null", activity);
    }

    @Test
    public void testCounter() {
        // given
        int counter = activity.getCounter();

        // when
        activity.addToCounter(2);
        int newCounter = activity.getCounter();

        // then
        assertTrue(newCounter == counter + 2);
    }

    @Test
    public void testHelloWorld() throws Exception {

        onView(withId(R.id.welcome_text)).check(matches(withText("We started!")));
    }

    @Test
    public void testChangeText() throws Exception {
        // given
        // We have our activity

        // when
        onView(withText("Change text")).perform(click());

        // then
        assertTrue(activity.getText().equals("We rock!"));

    }

    @Test
    public void testWillMoveToNextActivity() {
        onView(withId(R.id.next_button)).perform(click());
        onView(withId(R.id.next_activity_view)).check(matches(isDisplayed()));
    }
}