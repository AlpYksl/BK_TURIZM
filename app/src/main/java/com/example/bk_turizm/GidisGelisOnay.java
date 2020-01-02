package com.example.bk_turizm;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bk_turizm.Veritabanı.VeriTabanıİslemleri;

public class GidisGelisOnay extends AppCompatActivity {

    private TextView txtGelis,txtDonus;
    private Button btnİptal,btnAnasayfa,btnOnay;
    private int id,travel1,travel2;
    private void initialize()
    {
        btnOnay = (Button) findViewById(R.id.onayGidisGelis);
        txtGelis = (TextView) findViewById(R.id.txtOnaylama);
        txtDonus = (TextView) findViewById(R.id.txtOnay2);
        Intent ıntent = getIntent();
        txtGelis.setText(ıntent.getStringExtra("GelisBilet"));
        txtDonus.setText(ıntent.getStringExtra("DonusBilet"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gidis_gelis_onay);
        initialize();
        btnOnay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = clientID();
                String gelis = txtGelis.getText().toString();
                String[] arr = gelis.split("\n");
                travel1 = Integer.valueOf(arr[0].toString());
                String donus = txtDonus.getText().toString();
                String[] arr2 = donus.split("\n");
                travel2 = Integer.valueOf(arr2[0].toString());
                VeriTabanıİslemleri vt = new VeriTabanıİslemleri(GidisGelisOnay.this);
                vt.insertRezervasyon(id,travel1);
                vt.insertRezervasyon(id,travel2);
                biletOnayDialog().show();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void anasayfa_click(View view) {
        Intent anasayfa = new Intent(GidisGelisOnay.this,MainActivity.class);
        startActivity(anasayfa);
    }

    public void btnİptal(View view) {
        Intent ciftyön = new Intent(GidisGelisOnay.this,GidisGelis.class);
        startActivity(ciftyön);
    }
    public int clientID() {
        GirisActivity.sharedPreferences = getApplication().getSharedPreferences(GirisActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        id = GirisActivity.sharedPreferences.getInt(GirisActivity.CLIENT_ID, 0);
        return id;
    }
    public Dialog biletOnayDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Harika biletiniz onaylandı!!")
                .setCancelable(false)
                .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        Intent intent = new Intent(getApplicationContext(), Rezervasyonlar.class);
                        startActivity(intent);
                        finish();
                    }
                });

        return builder.create();
    }

}
