package com.tddsample.android.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.tddsample.android.R;

public class MapView extends FrameLayout {

    @SuppressWarnings("unused")
    public MapView(Context context) {
        super(context);
        init();
    }

    @SuppressWarnings("unused")
    public MapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @SuppressWarnings("unused")
    public MapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        try {
            inflater.inflate(R.layout.view_map, this, true);
        } catch (InflateException ex) {
            // fragment's cause layout InflateExceptions in Robolectric
            FrameLayout mockMap = new FrameLayout(getContext());
            mockMap.setId(R.id.map);
            addView(mockMap);
        }
    }
}
