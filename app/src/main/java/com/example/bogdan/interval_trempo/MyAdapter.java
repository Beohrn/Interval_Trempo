package com.example.bogdan.interval_trempo;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import java.util.List;


public class MyAdapter extends ArrayAdapter<ProgressInfo> {

    private static class ViewHolder {
        TextView textView;
        ProgressBar progressBar;
        Button button;
        ProgressInfo info;
    }


    public MyAdapter(Context context, int textViewResourceId,
                     List<ProgressInfo> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final ProgressInfo info = getItem(position);


        ViewHolder holder = null;

        if (null == row) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.progress_row, parent, false);

            holder = new ViewHolder();
            holder.textView = (TextView) row.findViewById(R.id.progressCounter);
            holder.progressBar = (ProgressBar) row.findViewById(R.id.progressBar);
            holder.button = (Button) row.findViewById(R.id.startButton);
            holder.info = info;

            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();

            holder.info.setProgressBar(null);
            holder.info = info;
            holder.info.setProgressBar(holder.progressBar);
        }

        if (holder.textView.getText().equals(info.getSize().toString())) {
            holder.textView.setText("Complete");
        } else {
            holder.textView.setText("...");
        }
        holder.progressBar.setProgress(info.getProgress());
        holder.progressBar.setMax(info.getSize());
        info.setTextView(holder.textView);
        info.setProgressBar(holder.progressBar);

        holder.button.setEnabled(info.getProgressState() == ProgressInfo.ProgressState.NOT_STARTED);
        final Button button = holder.button;
        holder.button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setProgressState(ProgressInfo.ProgressState.QUEUED);
                button.setEnabled(false);
                button.invalidate();
                MyTask task = new MyTask(info);
                task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        });

        return row;
    }

}
