package apex.app.restaurantapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_restaurants;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_restaurants = (RecyclerView) findViewById(R.id.rv_restaurants);
        adapter = new CustomAdapter(MainActivity.this);
        rv_restaurants.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rv_restaurants.setAdapter(adapter);
    }
}
