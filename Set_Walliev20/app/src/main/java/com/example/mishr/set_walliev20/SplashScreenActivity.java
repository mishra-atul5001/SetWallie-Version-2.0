package com.example.mishr.set_walliev20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Toast.makeText(this, "Bingo to Version 2.0", Toast.LENGTH_SHORT).show();
        for (int i=0;i<2000;i++){
            
        }
       Thread timer = new Thread(){
           @Override
           public void run() {
               try {
                   sleep(2500);
               }  catch (InterruptedException e){
                   e.printStackTrace();
               }
               finally {
                   Intent go_to_login_screen = new Intent(getApplicationContext(),MainActivity.class);
                  finish();
                   startActivity(go_to_login_screen);
               }
           }
       };
        timer.start();
        

    }
}
