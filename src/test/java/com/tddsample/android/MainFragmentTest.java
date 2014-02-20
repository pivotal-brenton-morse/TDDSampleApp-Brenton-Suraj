package com.tddsample.android;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.tddsample.android.fragments.MainFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static org.fest.assertions.api.ANDROID.assertThat;


@RunWith(RobolectricTestRunner.class)
public class MainFragmentTest {

    private FragmentActivity mActivity;
    private EditText mWhatText;
    private EditText mWhereText;
    private MainFragment mFragment;

    @Before
    public void setup() {
        mActivity = Robolectric.buildActivity(FragmentActivity.class).create().start().resume().visible().get();
        mFragment = new MainFragment();
        addFragment(mActivity, mFragment);

        mWhatText = (EditText) mFragment.getView().findViewById(R.id.what_text);
        mWhatText.setText("Restaurants");

        mWhereText = (EditText) mFragment.getView().findViewById(R.id.where_text);
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

    public static void addFragment(FragmentActivity activity, Fragment fragment) {
        addFragmentContainerToActivity(activity);
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    public static void addFragmentContainerToActivity(Activity activity) {
        FrameLayout view = new FrameLayout(activity);
        view.setId(R.id.fragment_container);
        activity.addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}