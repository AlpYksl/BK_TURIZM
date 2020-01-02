package com.example.bk_turizm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bk_turizm.Veritabanı.VeriTabanıİslemleri;

public class Rezervasyonlar extends AppCompatActivity {

    private SQLiteOpenHelper databaseİslemler;
    private SQLiteDatabase db;
    private Cursor cursor;
    private int ID;
    private ListView rezervasyonListesi;
    private TextView yolculukMesaj;

    private void initialize()
    {

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyonlar);
        rezervasyonListesi = (ListView) findViewById(R.id.lstRezrvasyon);
        yolculukMesaj = (TextView) findViewById(R.id.txtRezervasyon);
        yolculukMesaj.setVisibility(View.INVISIBLE);
        ID = yolcuID();
        try{
            databaseİslemler = new VeriTabanıİslemleri(Rezervasyonlar.this);
            db = databaseİslemler.getReadableDatabase();

            cursor = VeriTabanıİslemleri.selectRezervasyonJoinYolcularTravel(db, ID);

            if (cursor != null && cursor.getCount() > 0) {

                CursorAdapter listAdapter = new SimpleCursorAdapter(Rezervasyonlar.this,
                        R.layout.rezervasyon_custom_view,
                        cursor,
                        new String[]{"KALKIS", "GİDİS", "FIRSTNAME",
                                     "TARIH"},
                        new int[]{R.id.txtKalkışListe, R.id.txtGdişListe,
                                R.id.txtyolcuListe,R.id.txtTarihListe},
                        0);

                rezervasyonListesi.setAdapter(listAdapter);
            }else{

                yolculukMesaj.setVisibility(View.VISIBLE);
            }


        }catch (SQLiteException e){
            Toast.makeText(getApplicationContext(), "Veritabanı Hatası!!", Toast.LENGTH_SHORT).show();
        }

    }
    public int yolcuID() {
        GirisActivity.sharedPreferences = getApplication().getSharedPreferences(GirisActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        ID = GirisActivity.sharedPreferences.getInt(GirisActivity.CLIENT_ID, 0);
        return ID;
    }

}
