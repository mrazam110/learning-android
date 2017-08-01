package com.example.jawwad.biosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShowBio extends AppCompatActivity {

    private TextView tv_data;
    private ImageView iv_image;
    private Bundle extrs;
    private int position;
    private ArrayList<DataModel> dataModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bio);

        tv_data = (TextView) findViewById(R.id.tv_data);
        iv_image = (ImageView) findViewById(R.id.iv_img);

        extrs = getIntent().getExtras();
        if (extrs != null){
            position = extrs.getInt("position");
            dataModelArrayList = (ArrayList<DataModel>)extrs.getSerializable("data");
            tv_data.setText(dataModelArrayList.get(position).getDescription());
            iv_image.setImageResource(dataModelArrayList.get(position).getImages());
        }
    }
}
