package com.example.android.chandigarhtourguideapp;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.chandigarhtourguideapp.R;
import com.example.android.chandigarhtourguideapp.Tour;

import java.util.ArrayList;

public class TourAdapter extends ArrayAdapter<Tour> {
    public TourAdapter(Activity context, ArrayList<Tour> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Tour currentTour = getItem(position);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image_view);
        imageView.setImageResource(currentTour.getmImageResourceId());
        imageView.setVisibility(View.VISIBLE);
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        placeTextView.setText(currentTour.getmPlace());
        TextView placeDescriptionTextView = (TextView) listItemView.findViewById(R.id.place_description_text_view);
        placeDescriptionTextView.setText(currentTour.getmPlaceDescription());
        return listItemView;
    }
}