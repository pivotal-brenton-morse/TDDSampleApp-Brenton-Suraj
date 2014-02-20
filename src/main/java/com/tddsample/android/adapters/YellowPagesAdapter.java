package com.tddsample.android.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tddsample.android.R;
import com.tddsample.android.models.ListingInterface;

import java.util.List;

public class YellowPagesAdapter extends ArrayAdapter<ListingInterface> {

    public YellowPagesAdapter(Context context, int resource, List<ListingInterface> listings) {
        super(context, resource, listings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_restaurant, null);
        }

        ListingInterface listing = getItem(position);
        TextView nameTextView = (TextView) view.findViewById(R.id.list_item_restaurant_name);
        nameTextView.setText(listing.getName());

        TextView distTextView = (TextView) view.findViewById(R.id.list_item_restaurant_distance);
        distTextView.setText(listing.getDistance());

        return view;
    }

    public void setData(List<ListingInterface> listings) {
        clear();
        addAll(listings);
    }
}
