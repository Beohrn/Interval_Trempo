package com.example.bogdan.interval_trempo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class ItemAdapter implements SimpleAdapter.ViewBinder {


    @Override
    public boolean setViewValue(View view, Object data, String textRepresentation) {
        return false;
    }
}
