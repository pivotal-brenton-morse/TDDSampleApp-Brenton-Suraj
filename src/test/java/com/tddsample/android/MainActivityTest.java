package com.tddsample.android;

import android.widget.Button;
import android.widget.EditText;

import com.tddsample.android.activities.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mActivity;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
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
}
