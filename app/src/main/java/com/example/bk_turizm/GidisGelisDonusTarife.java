package com.example.bk_turizm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bk_turizm.Veritabanı.VeriTabanıİslemleri;

import java.util.List;

public class GidisGelisDonusTarife extends AppCompatActivity {
    private ListView lstDonus;
    private String kalkıs,gidis;
    private TextView gelişbilet;
    private int travelID;

    private void initialize()
    {
        lstDonus = (ListView) findViewById(R.id.lstDönüsBiletler);
        Intent bilet = new Intent(getIntent());
        gelişbilet = (TextView) findViewById(R.id.txtTarife);
        gelişbilet.setText(bilet.getStringExtra("Bilet"));
    }
    public void Listele()
    {
        Intent ıntent = new Intent(getIntent());
        kalkıs = ıntent.getStringExtra("Gelisbilet");
        gidis = ıntent.getStringExtra("Gidisbilet");
        VeriTabanıİslemleri vt = new VeriTabanıİslemleri(GidisGelisDonusTarife.this);
        List<String> listeler = vt.veriListele(gidis,kalkıs);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(GidisGelisDonusTarife.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,listeler);
        lstDonus.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gidis_gelis_donus_tarife);
        initialize();
        Listele();
        lstDonus.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String biletOnay = lstDonus.getItemAtPosition(position).toString();
                String tarife = gelişbilet.getText().toString();
                Intent gidisgelisOnay = new Intent(GidisGelisDonusTarife.this
                        ,GidisGelisOnay.class);
                gidisgelisOnay.putExtra("GelisBilet",tarife);
                gidisgelisOnay.putExtra("DonusBilet",biletOnay);
                startActivity(gidisgelisOnay);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
