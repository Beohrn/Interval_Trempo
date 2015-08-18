package com.example.bogdan.interval_trempo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.List;

/**
 * Created by Beohrn on 18.08.2015.
 */
public class ProgressInfo {

    private Integer size;
    private Integer progress;
    private ProgressBar progressBar;

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
}

