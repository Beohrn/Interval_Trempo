package com.example.bogdan.interval_trempo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = (ListView) findViewById(R.id.progressListView);
        Button button = (Button) findViewById(R.id.addButton);
        editText = (EditText) findViewById(R.id.editText);

        final List<ProgressInfo> items = new ArrayList<ProgressInfo>();

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                items.add(new ProgressInfo(Integer.valueOf(String.valueOf(editText.getText()))));
                editText.setText(null);
                listView.setAdapter(new MyAdapter(getApplicationContext(), R.id.progressListView, items));


            }
        });

    }


}
