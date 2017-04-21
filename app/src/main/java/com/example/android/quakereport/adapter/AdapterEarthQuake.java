package com.example.android.quakereport.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.entity.Earthquake;

import java.util.List;

/**
 * Created by obed.gonzalez on 20/04/2017.
 */

public class AdapterEarthquake extends ArrayAdapter<Earthquake> {

    private List<Earthquake> earthQuakes;
    private Context context;

    public AdapterEarthquake(Context context, List<Earthquake> earthQuakes) {
        super(context, 0, earthQuakes);
        this.earthQuakes = earthQuakes;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View mConvertView = convertView;

        if (mConvertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_list_item_earthquake, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtMagnitude = (TextView) convertView.findViewById(R.id.ctm_item_earthquake_txt_magnitude);
            viewHolder.txtLocation = (TextView) convertView.findViewById(R.id.ctm_item_earthquake_txt_location);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.ctm_item_earthquake_txt_date);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) mConvertView.getTag();
        }

        Earthquake earthQuake = earthQuakes.get(position);
        if (earthQuake != null) {
            viewHolder.txtMagnitude.setText(earthQuake.getMagnitude());
            viewHolder.txtLocation.setText(earthQuake.getLocation());
            viewHolder.txtDate.setText(earthQuake.getDate());
        }

        return convertView;
    }


    static class ViewHolder {
        TextView txtMagnitude;
        TextView txtLocation;
        TextView txtDate;
    }
}
