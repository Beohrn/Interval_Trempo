package com.example.bogdan.interval_trempo;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Beohrn on 18.08.2015.
 */
public class MyTask extends AsyncTask<Void, Integer, Void> {

    final ProgressInfo info;
    private int count;

    public MyTask(ProgressInfo info) {
        this.info = info;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        info.setProgress(values[0]);
        ProgressBar bar = info.getProgressBar();

        if (bar != null) {
            bar.setProgress(info.getProgress());
            bar.invalidate();

        }
    }

    @Override
    protected Void doInBackground(Void... voids) {
        count = info.getSize();
        for (int i = 0; i < info.getSize(); i++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
            count--;


        }

        return null;
    }
}
