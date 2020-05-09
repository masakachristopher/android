package com.chrisdev.newsroom.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.chrisdev.newsroom.users.*;
import com.chrisdev.newsroom.R;
import com.chrisdev.newsroom.database.DatabaseAdapter;

public class Login extends Activity {
    Button loginbtn, registerbtn;
    EditText username, password;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        textView = findViewById(R.id.textViewLink);
        textView.setMovementMethod(LinkMovementMethod.getInstance());


        loginbtn= (Button)findViewById(R.id.login_btn);
        username = (EditText) findViewById(R.id.et_regno);
        password = (EditText) findViewById(R.id.et_pass);


        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user_name = username.getText().toString();
                String pass_word = password.getText().toString();
                // TODO Auto-generated method stub

                if (TextUtils.isEmpty(user_name)) {
                    username.setError("Invalid Username");


                } else if (TextUtils.isEmpty(pass_word)) {
                    password.setError("Invalid password");
                } else {
                    DatabaseAdapter newsroomDB = new DatabaseAdapter(Login.this);
                    Boolean result = newsroomDB.validateAdmin(user_name, pass_word);
                    Staff staff = newsroomDB.validateStaff(user_name,pass_word);
                    Student student= newsroomDB.validateStudent(user_name,pass_word);

                    if (result.equals(true)) {
                        Intent intent = new Intent(Login.this, AdminMenu.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), " Welcome "+ user_name, Toast.LENGTH_LONG).show();
                    } else if(staff != null){
                        Intent intent = new Intent(Login.this, Menu.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), " Welcome ", Toast.LENGTH_LONG).show();
                    } else  if(student != null){
                        Intent intent = new Intent(Login.this, StudentMenu.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), " Welcome ", Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Login failed" + user_name, Toast.LENGTH_LONG).show();

                }


            }


        });

    }
}
