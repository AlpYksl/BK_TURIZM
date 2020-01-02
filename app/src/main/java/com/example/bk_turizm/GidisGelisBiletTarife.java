package com.example.bk_turizm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bk_turizm.Veritabanı.VeriTabanıİslemleri;

import java.util.List;

public class GidisGelisBiletTarife extends AppCompatActivity {
    private ListView lst;
    private String kalkıs,gidis;
    private int travelID;
    private void initialize()
    {
        lst = (ListView) findViewById(R.id.lstBilet);

    }

    public void Listele()
    {
        Intent ıntent = new Intent(getIntent());
        kalkıs = ıntent.getStringExtra("Gidis");
        gidis = ıntent.getStringExtra("Gelis");
        VeriTabanıİslemleri vt = new VeriTabanıİslemleri(GidisGelisBiletTarife.this);
        List<String> listeler = vt.veriListele(kalkıs,gidis);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(GidisGelisBiletTarife.this,
                android.R.layout.simple_list_item_1,android.R.id.text1,listeler);
        lst.setAdapter(adapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gidis_gelis_bilet_tarife);
        initialize();
        Listele();
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String biletlOnay = lst.getItemAtPosition(position).toString();
                travelID = (int) id;
                Intent onaysayfasi = new Intent(GidisGelisBiletTarife.this,GidisGelisDonusTarife.class);
                onaysayfasi.putExtra("Bilet",biletlOnay);
                onaysayfasi.putExtra("Gidisbilet",gidis);
                onaysayfasi.putExtra("Gelisbilet",kalkıs);
                onaysayfasi.putExtra("ID",id);
                startActivity(onaysayfasi);
            }
        });
    }
}
