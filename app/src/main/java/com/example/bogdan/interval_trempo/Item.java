package com.example.bogdan.interval_trempo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by bogdan on 09.08.2015.
 */
public class Item extends Activity {

    MainActivity context;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        Button button = (Button) findViewById(R.id.progressbar1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "svsdvsdv", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
