package com.example.bk_turizm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.*;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bk_turizm.Sınıflar.CustomAdapter;
import com.example.bk_turizm.Sınıflar.Sehir;

public class TekYon extends AppCompatActivity {

   private GridLayout grd;
   private Spinner spnKlks,spnGds;
   private ScrollView sv ;
   private Button btnTekYon,btnyeniİslem;
   private Sehir.Container container;
   private CustomAdapter adp;
   private LinearLayout pnlSeferler;


    private void initialize()
    {
        spnKlks = (Spinner) findViewById(R.id.spnkalkısSehirler);
        spnGds = (Spinner) findViewById(R.id.spnGidisSehirler);
        btnTekYon = (Button) findViewById(R.id.btnBiletbul);
        container = new Sehir.Container();
        adp = new CustomAdapter(this,container);
        spnKlks.setAdapter(adp);
        spnGds.setAdapter(adp);
    }
    private void yeniİslem_Click()//Refresh Activity
    {
        btnyeniİslem = (Button) findViewById(R.id.btnyeniİslem);
        btnyeniİslem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(getIntent());
            }
        });

    }

    private void kullanılanMetodlar(){
        yeniİslem_Click();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tek_yon);
        initialize();
        kullanılanMetodlar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void tkyn_BiletBul(View view) {
        if(spnKlks.getSelectedItem() != spnGds.getSelectedItem()){
        btnyeniİslem.setVisibility(View.VISIBLE);
        btnTekYon.setEnabled(false);
        final String s = spnKlks.getSelectedItem().toString();
        final String a = spnGds.getSelectedItem().toString();

        Intent biletSayasi = new Intent(TekYon.this,BiletTarife.class);
        biletSayasi.putExtra("Kalkıs",s);
        biletSayasi.putExtra("Gidis",a);
        startActivity(biletSayasi);
        } else{//Toast ekranı çıkmıyor
            Toast.makeText(TekYon.this,"Değerli kullanıcımız aynı kalkış ve gidiş yönüne seferimiz " +
                    "bulunmamaktadır",Toast.LENGTH_LONG).show();
            btnyeniİslem.setVisibility(View.VISIBLE);
        }
    }
}
