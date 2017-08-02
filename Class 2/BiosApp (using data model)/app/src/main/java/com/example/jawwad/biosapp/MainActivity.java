package com.example.jawwad.biosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv_names;
    private ArrayAdapter<String> adapter;
    private DataModel model;
    private ArrayList<DataModel> dataModelArrayList;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dataModelArrayList = settingDataModel();
        names = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            names.add(dataModelArrayList.get(i).getNames());
        }

        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item,R.id.tv_description, names);
        lv_names = (ListView) findViewById(R.id.lv_names);

        lv_names.setAdapter(adapter);

        lv_names.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this, ShowBio.class);
                i.putExtra("position",position);
                i.putExtra("data", dataModelArrayList);
                startActivity(i);
            }
        });

    }

    private ArrayList<DataModel> settingDataModel() {

        ArrayList<DataModel> dataModelArrayList = new ArrayList<>();
        model = new DataModel("Hazrat Muhammad s.a.w.w", "Considered by Muslims to be the last prophet sent by God to mankind. According to Muslims, God revealed to him the Quran, which is God's word and the greatest miracle.",R.drawable.muhammad_saww);
        dataModelArrayList.add(model);
        model = new DataModel("Hazrat Fatimah s.a", "Her father Muhammad called her \"a part of me\".[14] She is also regarded as \"the mother of the Imams.",R.drawable.fatimah_sa);
        dataModelArrayList.add(model);
        model = new DataModel("Hazrat Imam Ali a.s", "For all Shia, the son-in-law of Muhammad is the first Shia Imam[24] and the rightful successor of Muhammad.[25] For Sunnis, he is the fourth successor.[16] He holds an important position in almost all Sufi orders, which trace their lineage to Muhammad through him.",R.drawable.ali_as);
        dataModelArrayList.add(model);
        model = new DataModel("Hazrat Imam hasan a.s", "The eldest surviving grandson of Muhammad, through his mother, Fatimah, Hasan succeeded his father Ali as the caliph in Kufa; but after a seven-month reign he relinquished control of Iraq following a peace treaty with Muawiya I.",R.drawable.hassan_as);
        dataModelArrayList.add(model);
        model = new DataModel("Hazrat Imam hussain a.s", "Grandson of Muhammad and his younger brother of Hasan, Husayn rejected the legitimacy of Caliph Yazid I, the son of Muawiyah. As a result, he and his family were killed in the Battle of Karbala by Yazid's forces.[16] Ever since the battle, the commemoration of Husayn ibn Ali's martyrdom has been at the core of Shia rituals and identity.",R.drawable.hussain_as);
        dataModelArrayList.add(model);

        return dataModelArrayList;

    }
}
