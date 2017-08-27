package apex.app.imageapp;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView iv_profile_image;
    Button btn_opencam, btn_opengal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_profile_image = (ImageView) findViewById(R.id.profile_image);
        btn_opencam = (Button) findViewById(R.id.btn_opencam);
        btn_opengal = (Button) findViewById(R.id.btn_opengal);

        btn_opencam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
                            requestPermissions(new String[]{Manifest.permission.CAMERA}, 0);
                        }
                        else {
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent,0);
                        }
                    }
                    else {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,0);
                }
            }
        });

        btn_opengal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);
        }
        else {
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            iv_profile_image.setImageBitmap(photo);
            ObjectAnimator animator = ObjectAnimator.ofFloat(iv_profile_image, "rotationX",0f, 360f);
            animator.setDuration(500);
            animator.setStartDelay(500);
            animator.start();
        }

        else if (requestCode == 1 && resultCode == Activity.RESULT_OK){

            Bitmap photo = null;

            try {
                photo = MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
            iv_profile_image.setImageBitmap(photo);
        }
    }
}
