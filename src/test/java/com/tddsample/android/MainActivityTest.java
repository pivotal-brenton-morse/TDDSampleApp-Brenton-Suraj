package com.tddsample.android;

import android.app.Activity;
import android.widget.Button;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private Activity mActivity;
    private Button mButton;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        mButton = (Button) mActivity.findViewById(R.id.hello_button);
    }

    @Test
    public void buttonText_shouldBeBlack() {
        assertThat(mButton).hasText("Hello world!");
        assertThat(mButton).hasCurrentTextColor(R.color.black);
    }

    @Test
    public void clickButton_shouldChangeColor() {
        mButton.performClick();
        assertThat(mButton).hasCurrentTextColor(R.color.red);
    }
}
