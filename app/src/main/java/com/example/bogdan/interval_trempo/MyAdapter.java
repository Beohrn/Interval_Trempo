package com.example.bogdan.interval_trempo;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by bogdan on 10.08.2015.
 */
public class MyAdapter extends ArrayAdapter<ProgressInfo> {

    private static class ViewHolder {
        ProgressBar progressBar;
        ProgressInfo progressInfo;
        Button button;
        TextView textView;
    }

    public MyAdapter(Context context, int resource, List<ProgressInfo> objects) {
        super(context, resource, objects);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        final ProgressInfo info = getItem(position);

        ViewHolder holder = null;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.progress_row, parent, false);
            holder = new ViewHolder();
            holder.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
            holder.button = (Button) view.findViewById(R.id.button2);
            holder.textView = (TextView) view.findViewById(R.id.textView);
            holder.progressInfo = info;

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

            holder.progressInfo.setProgressBar(null);
            holder.progressInfo = info;
            holder.progressInfo.setProgressBar(holder.progressBar);
        }

        holder.textView.setText(info.getSize().toString());
        holder.progressBar.setProgress(info.getProgress());
        holder.progressBar.setMax(info.getSize());
        info.setProgressBar(holder.progressBar);
        holder.button.setEnabled(true);
        final Button button = holder.button;

        final ViewHolder finalHolder = holder;
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setEnabled(false);
                button.invalidate();

                MyTask task = new MyTask(info);
                task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

//                if (finalHolder.textView != null) {
//                    finalHolder.textView.setText(info.getCount());
//                }
            }
        });

        return view;
    }
}
