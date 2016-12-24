package com.login;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registration extends AppCompatActivity {

    SQLiteDatabase db;
    Button reg,cancel;
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        db=openOrCreateDatabase("temp.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        try{
            db.execSQL("create table login_details(name Text Primary Key,pass Text Not Null)");
            Toast.makeText(registration.this,"Table created",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
        }
        reg=(Button)findViewById(R.id.btnReg);
        cancel=(Button)findViewById(R.id.btnRegCancel);
        user=(EditText)findViewById(R.id.edRegUser);
        pass=(EditText)findViewById(R.id.edRegPass);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setText("");
                pass.setText("");
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues cv=new ContentValues();
                cv.put("name",user.getText().toString());
                cv.put("pass",pass.getText().toString());
                db.insert("login_details",null,cv);
                Toast.makeText(registration.this,"Registration successful",Toast.LENGTH_LONG).show();
                user.setText("");
                pass.setText("");
            }
        });
    }
}
