package apex.app.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Lenovo on 8/6/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private String[] restaurants = {
            "Al-Hayat",
            "Mehboob food center",
            "Chai ka hotel",
            "KFC",
            "McDonalds",
            "Yameen Kabab House"
    };

    private String[] description = {
            "Al-Hayat d",
            "Mehboob food center d",
            "Chai ka hotel d",
            "KFC d",
            "McDonalds d",
            "Yameen Kabab House d"
    };

    private int[] imagesId = {
            android.R.drawable.ic_dialog_alert,
            R.drawable.ic_launcher_background,
            android.R.drawable.dialog_frame,
            android.R.drawable.alert_light_frame,
            android.R.drawable.ic_dialog_alert,
            R.drawable.ic_launcher_background,
    };

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.title.setText(restaurants[position]);
        holder.description.setText(description[position]);
        holder.image.setImageResource(imagesId[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=24.874137,67.029339 (" + restaurants[position] + ")"));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.length;
    }

}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView title, description;
    ImageView image;

    public MyViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.tv_restaurant_name);
        description = (TextView) itemView.findViewById(R.id.tv_restaurant_desc);
        image = (ImageView) itemView.findViewById(R.id.iv_restaurant_image);

    }
}
