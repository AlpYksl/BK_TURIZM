package com.example.bk_turizm;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bk_turizm.Veritabanı.VeriTabanıİslemleri;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BiletTarife extends AppCompatActivity {

    private ListView lst;
    private String kalkıs,gidis;

    private void initialize()
    {
       lst = (ListView) findViewById(R.id.lstBiletler);

    }

    public void Listele()
    {
        Intent ıntent = new Intent(getIntent());
        String kalkıs = ıntent.getStringExtra("Kalkıs");
        String gidis = ıntent.getStringExtra("Gidis");
        VeriTabanıİslemleri vt = new VeriTabanıİslemleri(BiletTarife.this);
        List<String> listeler = vt.veriListele(kalkıs,gidis);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(BiletTarife.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,listeler);
        lst.setAdapter(adapter);
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet_tarife);
        initialize();
        Listele();
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String biletlOnay = lst.getItemAtPosition(position).toString();
                Intent onaysayfasi = new Intent(BiletTarife.this,OnaySayfasi.class);
                onaysayfasi.putExtra("Bilet",biletlOnay);
                startActivity(onaysayfasi);
            }
        });

    }



}
