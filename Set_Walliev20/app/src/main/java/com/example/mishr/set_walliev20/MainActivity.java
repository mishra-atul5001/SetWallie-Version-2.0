package com.example.mishr.set_walliev20;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,cancel;
    EditText username,password;
    String get_username,get_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username_editText);
        password = findViewById(R.id.password_editText);
        cancel = findViewById(R.id.cancel);
       // get_username = String.valueOf(username.getText());
       // get_password = String.valueOf(password.getText());
        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                      //  Toast.makeText(MainActivity.this, "Redirecting..!!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), CameraActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Try Again..!!", Toast.LENGTH_SHORT).show();
                    }
               
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Toast.makeText(MainActivity.this, "Visit Again..!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

   
}
