package com.example.jawwad.biosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowBio extends AppCompatActivity {

    private TextView tv_data;
    private ImageView iv_image;
    private String[] data = {
            "Considered by Muslims to be the last prophet sent by God to mankind. According to Muslims, God revealed to him the Quran, which is God's word and the greatest miracle.",
            "Her father Muhammad called her \"a part of me\".[14] She is also regarded as \"the mother of the Imams",
            "For all Shia, the son-in-law of Muhammad is the first Shia Imam[24] and the rightful successor of Muhammad.[25] For Sunnis, he is the fourth successor.[16] He holds an important position in almost all Sufi orders, which trace their lineage to Muhammad through him.",
            "The eldest surviving grandson of Muhammad, through his mother, Fatimah, Hasan succeeded his father Ali as the caliph in Kufa; but after a seven-month reign he relinquished control of Iraq following a peace treaty with Muawiya I.",
            "Grandson of Muhammad and his younger brother of Hasan, Husayn rejected the legitimacy of Caliph Yazid I, the son of Muawiyah. As a result, he and his family were killed in the Battle of Karbala by Yazid's forces.[16] Ever since the battle, the commemoration of Husayn ibn Ali's martyrdom has been at the core of Shia rituals and identity."
    };

    Bundle extrs;
    int position;
    int[] images = {
        R.drawable.muhammad_saww,
        R.drawable.fatimah_sa,
        R.drawable.ali_as,
        R.drawable.hassan_as,
        R.drawable.hussain_as
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bio);

        tv_data = (TextView) findViewById(R.id.tv_data);
        iv_image = (ImageView) findViewById(R.id.iv_img);

        extrs = getIntent().getExtras();
        if (extrs != null){
            position = extrs.getInt("position");
//            Toast.makeText(this, position+"", Toast.LENGTH_SHORT).show();
            tv_data.setText(data[position]);
            iv_image.setImageResource(images[position]);
        }




    }
}
