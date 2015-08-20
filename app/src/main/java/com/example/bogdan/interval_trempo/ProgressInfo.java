package com.example.bogdan.interval_trempo;

import android.widget.ProgressBar;
import android.widget.TextView;


public class ProgressInfo {

    public enum ProgressState {
        NOT_STARTED,
        QUEUED,
        PROCESSING,
        COMPLETE
    }

    private volatile ProgressState progressState = ProgressState.NOT_STARTED;

    private volatile Integer progress;
    private final Integer size;
    private volatile ProgressBar progressBar;
    private TextView textView;

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public ProgressInfo(Integer size) {
        progress = 0;
        this.size = size;
        progressBar = null;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public void setProgressState(ProgressState state) {
        progressState = state;
    }

    public ProgressState getProgressState() {
        return progressState;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getSize() {
        return size;
    }

}
