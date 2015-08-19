package com.example.bogdan.interval_trempo;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyTask extends AsyncTask<Void, Integer, Void> {

    final ProgressInfo info;
    TextView textView;

    public MyTask(ProgressInfo info) {
        this.info = info;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        info.setProgress(values[0]);
        ProgressBar bar = info.getProgressBar();
        textView = info.getTextView();
        textView.setText(values[0].toString());
        if (bar != null) {
            bar.setProgress(info.getProgress());
            bar.invalidate();
        }
    }

    @Override
    protected Void doInBackground(Void... params) {
        info.setProgressState(ProgressInfo.ProgressState.PROCESSING);
        for (int i = 0; i <= info.getSize(); ++i) {
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        info.setProgressState(ProgressInfo.ProgressState.COMPLETE);
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        info.setProgressState(ProgressInfo.ProgressState.COMPLETE);

        if (textView.getText().equals(info.getSize().toString())) {
            textView.setText("Complete");
        }
    }

    @Override
    protected void onPreExecute() {
        info.setProgressState(ProgressInfo.ProgressState.PROCESSING);


    }

}
