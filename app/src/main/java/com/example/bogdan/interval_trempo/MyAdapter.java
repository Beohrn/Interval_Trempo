package com.example.bogdan.interval_trempo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

/**
 * Created by bogdan on 10.08.2015.
 */
public class MyAdapter extends BaseAdapter {

    MainActivity activity;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(activity.getApplicationContext().LAYOUT_INFLATER_SERVICE);

        return null;
    }
}
