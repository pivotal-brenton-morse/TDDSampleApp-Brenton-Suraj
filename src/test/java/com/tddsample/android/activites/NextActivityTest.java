package com.tddsample.android.activites;

import android.content.Intent;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tddsample.android.RobolectricTestRunnerWithInjection;
import com.tddsample.android.activities.NextActivity;
import com.tddsample.android.utils.FakeCameraUpdateFactoryWrapper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.util.ActivityController;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunnerWithInjection.class)
public class NextActivityTest {

    static final String HAMBURG = "Hamburg", HAMBURG_LAT = "53.558", HAMBURG_LONG = "9.927";
    static final String KIEL = "Kiel", KIEL_LAT = "53.551", KIEL_LONG = "9.993";

    NextActivity activity;
    UiSettings mockUiSettings;
    Marker mockMarker;

    @Before
    public void setup() {
        ActivityController<NextActivity> controller = Robolectric.buildActivity(NextActivity.class);
        activity = controller.get();
        Intent intent = new Intent(Robolectric.getShadowApplication().getApplicationContext(), NextActivity.class);
        intent.putExtra("name", HAMBURG).putExtra("latitude", HAMBURG_LAT).putExtra("longitude", HAMBURG_LONG);
        setupMocks();
        controller.withIntent(intent).create().start();
        activity.setupMap();
        controller.resume().visible();
    }

    public void setupMocks() {
        mockUiSettings = mock(UiSettings.class);
        activity.map = mock(GoogleMap.class);
        mockMarker = mock(Marker.class);
        when(mockMarker.getPosition()).thenReturn(new LatLng(Double.parseDouble(HAMBURG_LAT), Double.parseDouble(HAMBURG_LONG)));
        when(activity.map.getUiSettings()).thenReturn(mockUiSettings);
        when(activity.map.addMarker(any(MarkerOptions.class))).thenReturn(mockMarker);
    }

    @Test
    public void setupMap_shouldAddMarker() {
        assertThat(((FakeCameraUpdateFactoryWrapper) activity.cameraUpdateFactoryWrapper).latLng).isEqualTo(new LatLng(Double.parseDouble(HAMBURG_LAT), Double.parseDouble(HAMBURG_LONG)));
        verify(mockUiSettings).setZoomControlsEnabled(false);
    }

}
