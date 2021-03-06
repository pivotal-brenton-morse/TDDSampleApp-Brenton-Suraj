package com.tddsample.android.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.inject.Inject;
import com.tddsample.android.R;
import com.tddsample.android.activities.NextActivity;
import com.tddsample.android.adapters.YellowPagesAdapter;
import com.tddsample.android.listeners.FetchModuleListener;
import com.tddsample.android.models.GeoCodeInterface;
import com.tddsample.android.models.ListingInterface;
import com.tddsample.android.models.ResultInterface;
import com.tddsample.android.modules.FetchModuleInterface;

import java.util.ArrayList;

import roboguice.fragment.RoboFragment;

public class MainFragment extends RoboFragment {

    ListView mRestaurantListView;
    YellowPagesAdapter mAdapter;
    Button searchButton;
    EditText whatText;
    EditText whereText;

    @Inject
    FetchModuleInterface fetchModule;

    FetchModuleListener listener = new FetchModuleListener() {
        @Override
        public void onSucess(ResultInterface result) {
            mAdapter.setData(result.getListings());
        }

        @Override
        public void onFailure() {
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mRestaurantListView = (ListView) view.findViewById(R.id.restaurant_list);
        searchButton = (Button) view.findViewById(R.id.search_button);
        whatText = (EditText) view.findViewById(R.id.what_text);
        whereText = (EditText) view.findViewById(R.id.where_text);

        fetchModule.setListener(listener);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchModule.fetch(whatText.getText().toString(), whereText.getText().toString());
            }
        });
        searchButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                whatText.setText("restaurants");
                whereText.setText("toronto");
                return true;
            }
        });
        mRestaurantListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListingInterface item = mAdapter.getItem(i);
                GeoCodeInterface geoCode = item.getGeoCode();
                if (geoCode != null) {
                    NextActivity.start(getActivity(), item.getName(), geoCode.getLatitude(), geoCode.getLongitude());
                } else {
                    Toast.makeText(getActivity(), "No location data", 5);
                }
            }
        });
        mAdapter = new YellowPagesAdapter(getActivity(), R.layout.list_item_restaurant, new ArrayList<ListingInterface>());
        mRestaurantListView.setAdapter(mAdapter);
    }
}