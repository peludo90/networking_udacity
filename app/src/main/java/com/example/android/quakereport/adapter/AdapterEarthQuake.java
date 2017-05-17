package com.example.android.quakereport.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.quakereport.R;
import com.example.android.quakereport.entity.Earthquake;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by obed.gonzalez on 20/04/2017.
 */

public class AdapterEarthquake extends ArrayAdapter<Earthquake> {

    private List<Earthquake> earthQuakes;
    private Context context;
    private DecimalFormat formatter;

    public AdapterEarthquake(Context context, List<Earthquake> earthQuakes) {
        super(context, 0, earthQuakes);
        this.earthQuakes = earthQuakes;
        this.context = context;
        formatter = new DecimalFormat("0.0");
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
            viewHolder.txtLocationOffset = (TextView) convertView.findViewById(R.id.ctm_item_earthquake_txt_location_offset);
            viewHolder.txtPrimaryLocation = (TextView) convertView.findViewById(R.id.ctm_item_earthquake_txt_primary_location);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.ctm_item_earthquake_txt_date);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) mConvertView.getTag();
        }

        Earthquake earthQuake = earthQuakes.get(position);
        if (earthQuake != null) {

            GradientDrawable magnitudeCircle = (GradientDrawable)  viewHolder.txtMagnitude.getBackground();
            // Get the appropriate background color based on the current earthquake magnitude
            int magnitudeColor = getMagnitudeColor(earthQuake.getMagnitude());
            // Set the color on the magnitude circle
            magnitudeCircle.setColor(magnitudeColor);

            viewHolder.txtMagnitude.setText(formatter.format(earthQuake.getMagnitude()));


            viewHolder.txtDate.setText(earthQuake.getDateFormatted());

            String location = earthQuake.getLocation();

            if (location.contains(" of ")) {
                /*String[] split = location.split(" of ");
                viewHolder.txtLocationOffset.setText(split[0]);
                viewHolder.txtPrimaryLocation.setText(split[1]);*/
                int indexOf = location.indexOf("of");
                viewHolder.txtLocationOffset.setText(location.substring(0, indexOf + 2).trim());
                viewHolder.txtPrimaryLocation.setText(location.substring(indexOf + 3).trim());

            } else {
                viewHolder.txtLocationOffset.setText(context.getString(R.string.near));
                viewHolder.txtPrimaryLocation.setText(location);
            }

        }

        return convertView;
    }


    private int getMagnitudeColor(double magnitude){

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }


    static class ViewHolder {
        TextView txtMagnitude;
        TextView txtLocationOffset;
        TextView txtPrimaryLocation;
        TextView txtDate;
    }
}
