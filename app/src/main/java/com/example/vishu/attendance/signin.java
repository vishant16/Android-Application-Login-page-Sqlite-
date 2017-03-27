package com.example.vishu.attendance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vishu.attendance.Contact;
import com.example.vishu.attendance.DataBaseHelper;
import com.example.vishu.attendance.R;

public class signin extends AppCompatActivity {

    DataBaseHelper helper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
    }

    public void onSignUpClick(View v) {
        if (v.getId() == R.id.button3) {
            EditText name = (EditText) findViewById(R.id.name);
            EditText email = (EditText) findViewById(R.id.branch);
            EditText uname = (EditText) findViewById(R.id.faculty);
            EditText pass1 = (EditText) findViewById(R.id.passcode);
            EditText pass2 = (EditText) findViewById(R.id.confirm);


            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();


            if (!pass1str.equals(pass2str)) {
                Toast pass = Toast.makeText(signin.this, "Passwords are not same", Toast.LENGTH_LONG);
                pass.show();
            }
            else {
                Contact c = new Contact();
                c.setName(namestr);
                c.setBranch(emailstr);
                c.setFaculty(unamestr);
                c.setPass(pass1str);


                helper.insertContact(c);

            }
        }

    }
}