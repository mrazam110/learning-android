package com.example.jawwad.class2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    private Bundle extras;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv_name = (TextView) findViewById(R.id.tv_name);

        extras = getIntent().getExtras();
        if (extras != null){
            String name = extras.getString("name");
            tv_name.setText(name);
        }
    }
}
