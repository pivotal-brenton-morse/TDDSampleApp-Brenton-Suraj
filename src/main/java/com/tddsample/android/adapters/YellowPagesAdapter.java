package com.tddsample.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tddsample.android.R;
import com.tddsample.android.models.Listing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dx156-xl on 2/20/14.
 */
public class YellowPagesAdapter extends ArrayAdapter<Listing> {

    private List<Listing> mListings = new ArrayList<Listing>();

    public YellowPagesAdapter(Context context, int resource, List<Listing> listings) {
        super(context, resource, listings);
        mListings.addAll(listings);
    }

    @Override
    public int getCount() {
        return mListings.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_restaurant, null);
        }

        Listing listing = mListings.get(position);
        TextView textView = (TextView) view.findViewById(R.id.list_item_restaurant_name);
        textView.setText(listing.getName());

        return view;
    }

    public void setData(List<Listing> listings) {
        mListings.clear();
        mListings.addAll(listings);
        notifyDataSetChanged();
    }
}
