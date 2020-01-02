package com.example.bk_turizm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.*;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.bk_turizm.Sınıflar.*;

public class GidisGelis extends AppCompatActivity {

    private Spinner spnGdsGls, spnGlsGds;
    private Sehir.Container container;
    private CustomAdapter adp;
    private LinearLayout pnlGdsGls;
    private Button yeniİslm, btnGdsGls, onaySayfasi;

    private void init()
    {
        btnGdsGls = (Button) findViewById(R.id.btnGdsGls);
        spnGdsGls = (Spinner) findViewById(R.id.spngdsgls);
        spnGlsGds = (Spinner) findViewById(R.id.spnglsgds);
        container = new Sehir.Container();
        adp = new CustomAdapter(this, container);
        spnGdsGls.setAdapter(adp);
        spnGlsGds.setAdapter(adp);
    }

    private void yeniİslem_Click()//Refresh Activity
    {
        yeniİslm = (Button) findViewById(R.id.btnYeniİslem);
        yeniİslm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(getIntent());
            }
        });

    }

    private void kullanılanMetodlar() {
        yeniİslem_Click();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gidis_gelis);
        init();
        kullanılanMetodlar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }


    public void btn_BiletBul(View view) {
        if(spnGdsGls.getSelectedItem() != spnGlsGds.getSelectedItem()){
            yeniİslm.setVisibility(View.VISIBLE);
            btnGdsGls.setEnabled(false);
            final String s = spnGdsGls.getSelectedItem().toString();
            final String a = spnGlsGds.getSelectedItem().toString();

            Intent biletSayasi = new Intent(GidisGelis.this,GidisGelisBiletTarife.class);
            biletSayasi.putExtra("Gidis",s);
            biletSayasi.putExtra("Gelis",a);
            startActivity(biletSayasi);
        } else{//Toast ekranı çıkmıyor
            Toast.makeText(GidisGelis.this,"Değerli kullanıcımız aynı kalkış ve gidiş yönüne seferimiz " +
                    "bulunmamaktadır",Toast.LENGTH_LONG).show();
            yeniİslm.setVisibility(View.VISIBLE);
        }
    }
}
