package invision.app.biosapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] names = {
            "Hazrat Muhammad s.a.w.w",
            "Hazrat Fatimah s.a",
            "Hazrat Imam Ali a.s",
            "Hazrat Imam hasan a.s",
            "Hazrat Imam hussain a.s",
    };

    private ListView lv_names;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.list_item,R.id.tv_description, names);
        lv_names = (ListView) findViewById(R.id.lv_names);

        lv_names.setAdapter(adapter);

        lv_names.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(MainActivity.this, ShowBio.class);
                i.putExtra("position",position);
                startActivity(i);
            }
        });

    }
}
