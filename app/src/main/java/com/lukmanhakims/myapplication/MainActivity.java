package com.lukmanhakims.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lukmanhakims.myapplication.models.DatabaseListDataPulsa;
import com.lukmanhakims.myapplication.models.Session;
import com.lukmanhakims.myapplication.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{
        public List<User> user;
        public EditText text_username, text_password;
        public Button button_login;
        public Session session;
        DatabaseListDataPulsa db;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            session= new Session(this);
            if (session.getHasLogin()){
                this.intent = new Intent(MainActivity.this, ListDataPulsa.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
                startActivity(intent);
//
                finish();
            }

            user = new ArrayList<>();
            user.add(new User("admin", "1234"));

            text_username = (EditText) findViewById(R.id.etName);
            text_password = (EditText) findViewById(R.id.etPassword);
            button_login = (Button) findViewById(R.id.btnLogin);

            button_login.setOnClickListener (new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User tmpUser = null;
                    for (User use : user) {
                        if (use.getUsername().equals(text_username.getText().toString()) && use.getPassword().equals(text_password.getText().toString())) {
                            tmpUser = use;

                        }
                    }

                    if (tmpUser != null) {
                        SharedPreferences spUser = MainActivity.this.getSharedPreferences("Userlogin", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = spUser.edit();
                        edit.putString("sedangLogin", tmpUser.getUsername());
                        edit.apply();

                        session.saveBoolean(session.SP_Has_Login,true);

                        Intent intent = new Intent(MainActivity.this, ListDataPulsa.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Maaf Username atau Password Salah", Toast.LENGTH_LONG).show();
                    }
                }
            });

            db = new DatabaseListDataPulsa(this);


    }

}
