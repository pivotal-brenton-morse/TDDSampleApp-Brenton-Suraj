package com.tddsample.android;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

import static org.fest.assertions.api.ANDROID.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.shadowOf;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private Activity mActivity;
    private Button mHelloButton;
    private Button mNextButton;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mHelloButton = (Button) mActivity.findViewById(R.id.hello_button);
        mNextButton = (Button) mActivity.findViewById(R.id.next_activity_button);
    }

    @Test
    public void buttonText_shouldBeBlack() {
        assertThat(mHelloButton).hasText("Hello world!");
        assertThat(mHelloButton).hasCurrentTextColor(mActivity.getResources().getColor(R.color.black));
    }

    @Test
    public void clickButton_shouldChangeColor() {
        mHelloButton.performClick();
        assertThat(mHelloButton).hasCurrentTextColor(mActivity.getResources().getColor(R.color.red));
    }

    @Test
    public void clickButton_shouldLaunchNextActivity() {
        mNextButton.performClick();
        ShadowActivity shadowActivity = shadowOf(mActivity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertThat(startedIntent.getComponent().getClassName()).isSameAs(NextActivity.class.getName());
     }
}
