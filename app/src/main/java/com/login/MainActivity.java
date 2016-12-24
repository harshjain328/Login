package com.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login,cancel;
    EditText user,pass;
    //SQLiteDatabase db;
    CheckBox rem;
    SharedPreferences sh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sh=getSharedPreferences("login",0);
        final SharedPreferences.Editor editor=sh.edit();
        login=(Button)findViewById(R.id.btnLogin);
        cancel=(Button)findViewById(R.id.btnCancel);
        user=(EditText)findViewById(R.id.edUser);
        pass=(EditText)findViewById(R.id.edPass);
        rem=(CheckBox)findViewById(R.id.checkBox);
        //db=openOrCreateDatabase("temp.db",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Cursor fetch=db.rawQuery("select * from login_details where name=?",new String[]{user.getText().toString()});
                fetch.moveToNext();
                String password=fetch.getString(1);
                if(password.equals(pass.getText().toString())){
                    Toast.makeText(MainActivity.this,"Login successful",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Enter correct password",Toast.LENGTH_LONG).show();*/
                //String str="Username: "+fetch.getString(0)+" Password: "+fetch.getString(1);
                //Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
                if(rem.isChecked()){
                    editor.putString("name",user.getText().toString());
                    editor.putString("password",pass.getText().toString());
                    editor.commit();
                    Intent i=new Intent(MainActivity.this,display.class);
                    startActivity(i);
                }
                else{
                    Intent i=new Intent(MainActivity.this,display.class);
                    startActivity(i);
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setText("");
                pass.setText("");
            }
        });
    }
}
