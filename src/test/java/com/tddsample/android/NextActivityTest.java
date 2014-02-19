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
public class NextActivityTest {

    private Activity mActivity;
    private TextView mTextView;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(NextActivity.class).create().get();
        mTextView = (TextView) mActivity.findViewById(R.id.second_text);
    }

    @Test
    public void textView_shouldHaveTextSecondActivity() {
        assertThat(mTextView).hasText("Second activity!");
    }
}
