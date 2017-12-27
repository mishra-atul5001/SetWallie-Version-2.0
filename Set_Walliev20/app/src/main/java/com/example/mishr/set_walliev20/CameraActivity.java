package com.example.mishr.set_walliev20;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class CameraActivity extends AppCompatActivity {
    ImageView image_set_view;
    Button camera_open , set_wallie;
    Bitmap bitmap;
    private static final int TIME_DELAY = 2000;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    image_set_view = findViewById(R.id.image_view);
    camera_open = findViewById(R.id.open_camera);
    set_wallie = findViewById(R.id.set_wallpaper);

        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        Toast.makeText(this, "Make Sure to click first..!!", Toast.LENGTH_SHORT).show();
        

        camera_open.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,123);
            Toast.makeText(CameraActivity.this, "Camera Activated..!!", Toast.LENGTH_SHORT).show();
           
        }
    });
    set_wallie.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                try {
                    // getApplicationContext().setWallpaper(bitmap);
                    wallpaperManager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(CameraActivity.this, "Wallpaper Updated", Toast.LENGTH_SHORT).show();
            }
    });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            Bundle bundle = data.getExtras();
            bitmap = (Bitmap)bundle.get("data");
            image_set_view.setImageBitmap(bitmap);
        }
    }
    @Override
    public void onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            super.onBackPressed();
          //  Toast.makeText(this, "Thank You for your support..!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        }
        back_pressed = System.currentTimeMillis();

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menus,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.rate_it){
            Toast.makeText(this, "Soon will be on Playstore..!!", Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.share_it){
            Intent sharingintent = new Intent(Intent.ACTION_SEND);
            sharingintent.setType("text/plain");
            sharingintent.putExtra(Intent.EXTRA_TEXT,"An App which let's users mood decide their wallpaper..!!");
            sharingintent.setPackage("com.whatsapp");
            startActivity(sharingintent);
        }
        else if (id==R.id.settings){
            Toast.makeText(this, "Settings are on the Way..!!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
