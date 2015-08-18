package com.example.bogdan.interval_trempo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Beohrn on 18.08.2015.
 */
public class ProgressInfo {

    private Integer size;
    private Integer progress;
    private ProgressBar progressBar;
    private TextView textView;
    private Integer count;

    public ProgressInfo(Integer size) {
        this.size = size;
        this.progress = 0;
        this.progressBar = null;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer Progress) {
        this.progress = Progress;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCount() {

        return Integer.toString(count);
    }

    public TextView getTextView() {

        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }
}

