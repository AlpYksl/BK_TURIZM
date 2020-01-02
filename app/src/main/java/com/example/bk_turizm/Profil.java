package com.example.bk_turizm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bk_turizm.Sınıflar.Hesap;
import com.example.bk_turizm.Sınıflar.Yolcu;
import com.example.bk_turizm.Veritabanı.HelperUtilities;
import com.example.bk_turizm.Veritabanı.VeriTabanıİslemleri;

import java.io.ByteArrayOutputStream;

import static android.provider.MediaStore.Images.Media.getBitmap;

public class Profil extends AppCompatActivity {


    private int clientID;
    private SQLiteOpenHelper databaseHelper;
    private SQLiteDatabase db;
    private Cursor cursor;
    private TextView clientFirstname;
    private TextView clientLastName;
    private TextView clientEmail;
    private TextView clientPhone;
    private TextView fullName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        clientID = clientID();
        kullanıcıSorgula(clientID);
    }

    public void kullanıcıSorgula(int employeeID) {
        try {

            clientFirstname = (TextView) findViewById(R.id.txtClientFirstName);
            clientLastName = (TextView) findViewById(R.id.txtClientLastName);
            clientEmail = (TextView) findViewById(R.id.txtClientEmail);
            clientPhone = (TextView) findViewById(R.id.txtClientPhone);
            fullName = (TextView) findViewById(R.id.txtFullName);


            databaseHelper = new VeriTabanıİslemleri(getApplicationContext());
            db = databaseHelper.getReadableDatabase();

            cursor = VeriTabanıİslemleri.selectYolcuJoinHesap(db, clientID);


            if (cursor != null && cursor.getCount() > 0) {
                cursor.moveToFirst();
                String fName = cursor.getString(0);
                String lName = cursor.getString(1);
                String phone = cursor.getString(2);
                String email = cursor.getString(3);

                Yolcu client = new Yolcu(fName, lName, phone);
                Hesap account = new Hesap(email);

                clientFirstname.setText("İsim : " + client.getFirstName());
                clientLastName.setText("Soyisim: " + client.getLastName());
                clientPhone.setText("Telefon: " + client.getPhone());
                clientEmail.setText("Email: " + account.getEmail());
                fullName.setText(client.getFirstName() + " " + client.getLastName());
            }

        } catch (SQLiteException ex) {
            Toast.makeText(getApplicationContext(), "Database unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    public int clientID() {
        GirisActivity.sharedPreferences = getSharedPreferences(GirisActivity.MY_PREFERENCES, Context.MODE_PRIVATE);
        clientID = GirisActivity.sharedPreferences.getInt(GirisActivity.CLIENT_ID, 0);
        return clientID;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            cursor.close();
            db.close();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Hata veritabanı", Toast.LENGTH_SHORT).show();
        }
    }

    public void hesabıKapat_Click(View view) {
        getApplicationContext().getSharedPreferences(GirisActivity.MY_PREFERENCES, 0).edit().clear().commit();
        Intent intent = new Intent(getApplicationContext(), GirisActivity.class);
        startActivity(intent);
        finish();
    }
}
