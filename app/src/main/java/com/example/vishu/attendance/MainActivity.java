package com.example.vishu.attendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper helper=new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void register(View v)
    {
        if(v.getId()==R.id.login_button)
        {
            EditText ed1=(EditText)findViewById(R.id.faculty_id);
            String s1=ed1.getText().toString();
            EditText ed2=(EditText)findViewById(R.id.passcode);
            String s2=ed2.getText().toString();

            String password=helper.searchPass(s1);

            if(s2.equals(password))
            {
                Intent intent=new Intent(this,semester.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this,"INVALID",Toast.LENGTH_LONG).show();
            }

        }
        if(v.getId()==R.id.sign_button)
        {
            Intent intent=new Intent(this,signin.class);
            startActivity(intent);
        }

    }




}
