package com.tddsample.android;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;

import com.tddsample.android.activities.MainActivity;
import com.tddsample.android.activities.NextActivity;

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

    private MainActivity mActivity;
    private EditText mWhatText;
    private EditText mWhereText;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();

        mWhatText = (EditText) mActivity.findViewById(R.id.what_text);
        mWhatText.setText("Restaurants");

        mWhereText = (EditText) mActivity.findViewById(R.id.where_text);
        mWhereText.setText("Toronto");
    }

    @Test
    public void whatText_shouldHaveHintWhat() {
        EditText whatText = (EditText) mActivity.findViewById(R.id.what_text);
        assertThat(whatText).hasHint("What");
    }

    @Test
    public void whereText_shouldHaveHintWhere() {
        EditText whereText = (EditText) mActivity.findViewById(R.id.where_text);
        assertThat(whereText).hasHint("Where");
    }

    @Test
    public void searchButton_shouldHaveTextSearch() {
        Button searchButton = (Button) mActivity.findViewById(R.id.search_button);
        assertThat(searchButton).hasText("Search");
    }

    @Test
    public void searchButtonClick_shouldLaunchNextActivity() {
        Button searchButton = (Button) mActivity.findViewById(R.id.search_button);
        searchButton.performClick();
        ShadowActivity shadowActivity = shadowOf(mActivity);
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        assertThat(startedIntent.getComponent().getClassName()).isSameAs(NextActivity.class.getName());
        assertThat(startedIntent.getExtras().getString("what")).isNotEmpty();
        assertThat(startedIntent.getExtras().getString("where")).isNotEmpty();
    }
}
