package com.example.bk_turizm;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class OnaySayfasi extends AppCompatActivity {

    private LinearLayout pnlOnay;
    private TextView txtOnay;
    private ImageView dogruresim, yanlisresim;
    private void initialize()
    {
        txtOnay = (TextView) findViewById(R.id.txtOnay);
        Intent intent = getIntent();
        txtOnay.setText(intent.getStringExtra("Bilet")+"\t");
        dogruresim = (ImageView) findViewById(R.id.dogruResim);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onay_sayfasi);
        initialize();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }

    public void anasayfa_click(View view)
    {
        Intent anasayfa = new Intent(OnaySayfasi.this,MainActivity.class);
        startActivity(anasayfa);
    }


    public void btnİptal(View view)
    {
        Intent tekyön = new Intent(OnaySayfasi.this,TekYon.class);
        startActivity(tekyön);
    }
}
