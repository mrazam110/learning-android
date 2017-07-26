package com.example.muhammadraza.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView text;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        text = (TextView) findViewById(R.id.text);
        editText = (EditText) findViewById(R.id.edittext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                text.setText("Taha Naqvi");

              String name = editText.getText().toString();
              text.setText(name);

            }
        });


    }

}
