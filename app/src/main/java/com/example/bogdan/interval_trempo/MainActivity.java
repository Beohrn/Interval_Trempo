package com.example.bogdan.interval_trempo;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_item_task);
        final EditText editText = (EditText) findViewById(R.id.edit_query);
        Button button = (Button) findViewById(R.id.addTask);
        final ArrayList<String> taskItems = new ArrayList<>();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.itemtext, taskItems);
        listView.setAdapter(adapter);

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = editText.getText().toString();

                taskItems.add(0, string);
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + position);
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        taskItems.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }
                });
                adb.show();

                return true;
            }
        });


    }
}