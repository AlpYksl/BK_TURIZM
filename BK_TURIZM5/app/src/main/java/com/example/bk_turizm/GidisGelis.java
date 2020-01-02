package com.example.bk_turizm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.*;
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
        pnlGdsGls = (LinearLayout) findViewById(R.id.pnlSeferBul);
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

    private String randomSaatBelirle() {
        int saat = (int) Math.round(1 + Math.random() * 48);
        if (saat >= 24) {
            return saat / 24 + "gün" + saat % 24 + "saat kaldı.";
        } else {
            return String.valueOf(saat);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gidis_gelis);
        init();
        kullanılanMetodlar();
    }


    public void btn_BiletBul(View view) {
        if (spnGdsGls.getSelectedItem() != spnGlsGds.getSelectedItem()) {
            btnGdsGls.setEnabled(false);
            pnlGdsGls.setVisibility(View.VISIBLE);
            TextView txt1, txt2, txt3;
            GridLayout pnl = new GridLayout(this);
            pnl.setOrientation(GridLayout.HORIZONTAL);
            pnl.setBackgroundColor(Color.GREEN);
            pnl.setColumnCount(4);
            pnl.setRowCount(3);
            pnl.setUseDefaultMargins(true);
            for (int i = 0; i < 3 + Math.random() * 7; i++) {
                txt1 = new TextView(this);
                txt1.setText("Kalkış:" + spnGdsGls.getSelectedItem().toString() + "\n" + "Gidiş:"
                        + spnGlsGds.getSelectedItem().toString()
                        + "\n"
                        + "Tarih:16/10/1996");
                txt1.setTextSize(15);
                txt1.setTypeface(Typeface.DEFAULT_BOLD);
                txt2 = new TextView(this);
                txt2.setText("126,99 TL" + 13);
                txt2.setTextSize(15);
                txt2.setTextColor(Color.WHITE);
                txt2.setTypeface(Typeface.DEFAULT_BOLD);
                txt3 = new TextView(this);
                txt3.setTextSize(15);
                txt3.setText("" + randomSaatBelirle());
                txt3.setTypeface(Typeface.DEFAULT_BOLD);
                onaySayfasi = new Button(this);
                onaySayfasi.setTextSize(18);
                onaySayfasi.setPadding(20, 20, 20, 20);
                onaySayfasi.setText("Click");
                final String s = "Kalkış:" + spnGdsGls.getSelectedItem().toString();
                final String a = "Gidis:" + spnGlsGds.getSelectedItem().toString();
                final String c = "Fiyat:" + txt2.getText().toString();
                final String d = "Tarih:" + txt3.getText().toString();
                onaySayfasi.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v) {
                        Intent onaySayfasi = new Intent(GidisGelis.this, OnaySayfasi.class);
                        onaySayfasi.putExtra("Gidiş", s);
                        onaySayfasi.putExtra("Kalkış", a);
                        onaySayfasi.putExtra("Ücret", c);
                        onaySayfasi.putExtra("Tarih", d);
                        startActivity(onaySayfasi);
                    }
                });
                pnl.addView(txt1);
                pnl.addView(txt2);
                pnl.addView(txt3);
                pnl.addView(onaySayfasi);
            }
            pnlGdsGls.addView(pnl);
        }else{
            Toast.makeText(GidisGelis.this,"Değerli kullanıcımız aynı kalkış ve gidiş yönüne seferimiz " +
                    "bulunmamaktadır",Toast.LENGTH_LONG).show();
            pnlGdsGls.setVisibility(View.INVISIBLE);
        }
    }
}
