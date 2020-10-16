package com.lukmanhakims.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.lukmanhakims.myapplication.models.DatabaseListDataPulsa;
import com.lukmanhakims.myapplication.models.Session;

import java.util.ArrayList;

public class ListDataPulsa extends AppCompatActivity {
    RecyclerView recyclerView;
    NoteAdapter adapter;
    ArrayList<NoteDataPulsa> notedatapulsa;
    DatabaseListDataPulsa db;
    Cursor cursor;
    Button plus;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_pulsa);

        db = new DatabaseListDataPulsa(this);

        recyclerView = (RecyclerView) findViewById(R.id.rv_notes);
        plus = (Button) findViewById(R.id.plus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListDataPulsa.this, TambahDataPulsa.class);
                startActivity(intent);
                finish();
            }
        });
        
        AddDataPulsa();
    }
    @Override
    protected void onResume() {
        super.onResume();
        AddDataPulsa();
    }

    private void AddDataPulsa() {
        notedatapulsa = new ArrayList<>();
        SQLiteDatabase dbsql = db.getReadableDatabase();
        cursor = dbsql.rawQuery("SELECT * FROM note",null);
        cursor.moveToFirst();


        if(cursor.getCount() > 0){
            do {

                notedatapulsa.add(new NoteDataPulsa(cursor.getString(cursor.getColumnIndex("nama")),cursor.getString(cursor.getColumnIndex("jumlah")),cursor.getString(cursor.getColumnIndex("deskripsi_status"))));

            } while (cursor.moveToNext());
        }
        adapter = new NoteAdapter(notedatapulsa);

        layoutManager = new LinearLayoutManager(ListDataPulsa.this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);
    }



    public void logout(View view) {
        Log.d(LOG_TAG, "Logout");
        SharedPreferences preferences = getSharedPreferences(Session.SP_Tiens_APP,MODE_PRIVATE);
        preferences.edit().putBoolean(Session.SP_Has_Login,false).apply();
        startActivity(new Intent(ListDataPulsa.this,MainActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}
