package com.tddsample.android.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.tddsample.android.R;
import com.tddsample.android.adapters.YellowPagesAdapter;
import com.tddsample.android.models.Listing;
import com.tddsample.android.models.Result;
import com.tddsample.android.utils.YellowPagesApiUtils;
import com.xtreme.network.NetworkRequest;
import com.xtreme.network.NetworkRequestLauncher;
import com.xtreme.network.NetworkResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    ListView mRestaurantListView;
    YellowPagesAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mRestaurantListView = (ListView) view.findViewById(R.id.restaurant_list);

        final EditText whatText = (EditText) view.findViewById(R.id.what_text);
        final EditText whereText = (EditText) view.findViewById(R.id.where_text);
        Button searchButton = (Button) view.findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncYellowPagesLoader().execute(whatText.getText().toString(), whereText.getText().toString());
            }
        });
        searchButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                whatText.setText("restaurants");
                whereText.setText("toronto");
                return false;
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new YellowPagesAdapter(getActivity(), R.layout.list_item_restaurant, new ArrayList<Listing>());
        mRestaurantListView.setAdapter(mAdapter);
    }

    private class AsyncYellowPagesLoader extends AsyncTask<String, Void, Result> {

        @Override
        protected Result doInBackground(String... strings) {
            NetworkRequest networkRequest = new NetworkRequest(YellowPagesApiUtils.getRequestUrl(strings[0], strings[1]));
            Result result = null;
            try {
                NetworkResponse networkResponse = NetworkRequestLauncher.getInstance().executeRequestSynchronously(networkRequest);
                InputStreamReader inputStreamReader = new InputStreamReader(networkResponse.getInputStream());
                result = new Gson().fromJson(inputStreamReader, Result.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Result result) {
            super.onPostExecute(result);
            if (result != null) {
                mAdapter.setData(result.getListings());
            }
        }
    }
}
