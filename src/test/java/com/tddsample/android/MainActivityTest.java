package com.tddsample.android;

import android.app.Activity;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private Activity mActivity;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void shouldHaveHelloWorld() {
        TextView textView = (TextView) mActivity.findViewById(R.id.hello_text);
        assertThat(textView).hasText("Hello world!");
    }
}
