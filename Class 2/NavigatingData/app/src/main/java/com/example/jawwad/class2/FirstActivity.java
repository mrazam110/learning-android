package com.example.jawwad.class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    private Button btn_switch_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btn_switch_activity = (Button) findViewById(R.id.btn_switch_activity);

        btn_switch_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                i.putExtra("name","Taha Naqvi");
                startActivity(i);
            }
        });


    }
}
