package com.login;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class display extends AppCompatActivity {

    TextView user,pass;
    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        user=(TextView)findViewById(R.id.textView);
        pass=(TextView)findViewById(R.id.textView2);
        sh=getSharedPreferences("login",0);
        user.setText(sh.getString("name","You didn't save anything nigga"));
        pass.setText(sh.getString("password","Bruh same problem"));
    }
}
