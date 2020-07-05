package com.nikhil.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void click(View v){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        String get = username.getText().toString();
        String get1 = password.getText().toString();

        if(get.equals("nikhilgajam@gmail.com") && get1.equals("Nikhil")){
            Toast t = Toast.makeText(getApplicationContext(), "Access Granted", Toast.LENGTH_LONG);
            t.show();
            Intent act = new Intent(LoginPage.this, Details.class);
            startActivity(act);
            finish();
        }else{
            Toast t = Toast.makeText(getApplicationContext(), "Unauthorized User", Toast.LENGTH_LONG);
            t.show();
        }

    }


}