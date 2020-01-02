package com.example.bk_turizm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bk_turizm.Veritabanı.VeriTabanıİslemleri;

import java.util.List;

public class OnaySayfasi extends AppCompatActivity {

    private TextView txtOnay;
    private ImageView dogruresim;
   // private Button onaylama;
    private int id,travelID;

    private void initialize()
    {
        txtOnay = (TextView) findViewById(R.id.txtOnay);
        Intent intent = getIntent();
        txtOnay.setText(intent.getStringExtra("Bilet")+"\n"+intent.getStringExtra("ID"));
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
    public void btn_BiletOnay(View view) {
        try{
            id = clientID();
            String s =  txtOnay.getText().toString();
            String[] arr = s.split("\n");
            travelID = Integer.valueOf(arr[0].toString());
            VeriTabanıİslemleri vt = new VeriTabanıİslemleri(OnaySayfasi.this);
            vt.insertRezervasyon(id,travelID);
            biletOnayDialog().show();
        }catch (SQLiteException ex){
         Toast.makeText(OnaySayfasi.this,"Hata Veritabanı!",Toast.LENGTH_LONG).show();
        }
    }

    public int clientID() {
        GirisActivity.sharedPreferences = getApplication().getSharedPreferences(GirisActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        id = GirisActivity.sharedPreferences.getInt(GirisActivity.CLIENT_ID, 0);
        return id;
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
