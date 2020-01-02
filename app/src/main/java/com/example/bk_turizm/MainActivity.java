package com.example.bk_turizm;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDoalog;
    private TextView txt;
    @Override
    protected void onStart() {
        super.onStart();
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Yolculuklar Güncelleniyor....");
        progressDoalog.setTitle("Lütfen Bekleyiniz");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDoalog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progressDoalog.getProgress() <= progressDoalog
                            .getMax()) {
                        Thread.sleep(200);
                        handle.sendMessage(handle.obtainMessage());
                        if (progressDoalog.getProgress() == progressDoalog
                                .getMax()) {
                            progressDoalog.dismiss();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    Handler handle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDoalog.incrementProgressBy(5);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.txtMain);
        txt.setText("Aşağıdaki resimlere dokunarak\nyolculuğunuzu planlayabilirsiniz.");
        MainActivity.this.setTitle("BK Turizm");
    }

    public void tek_YonClick(View view)
    {
        Intent tkyn = new Intent(MainActivity.this, TekYon.class);
        startActivity(tkyn);
    }

    public void ciftYonClick(View view)
    {
        Intent gdsgels = new Intent(MainActivity.this,GidisGelis.class);
        startActivity(gdsgels);
    }

   public boolean onCreateOptionsMenu(Menu m)
   {
       MenuInflater mi  = this.getMenuInflater();
       mi.inflate(R.menu.ana_menu,m);
       return true;
   }
   public boolean onOptionsItemSelected(MenuItem item)
   {
       switch (item.getItemId())
       {
           case R.id.mnuHesabım:
            Intent profil = new Intent(MainActivity.this,Profil.class);
            startActivity(profil);
            break;
           case R.id.mnuYardım:
               AlertDialog.Builder dlg = new AlertDialog.Builder(this,AlertDialog.THEME_HOLO_LIGHT);
               dlg.setTitle("YARDIM");
               dlg.setMessage("Uygulama hakkında merak ettikleriniz için " +
                       "bktourism@bk.com adresinden " +
                       "bize ulaşabilirsiniz.");
               dlg.setIcon(R.drawable.bus);

               dlg.setPositiveButton("TAMAM", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       startActivity(getIntent());
                   }
               });
               AlertDialog ad = dlg.create();
               dlg.show();
       }
       return super.onOptionsItemSelected(item);
   }

    public void rezerv_Click(View view) {

        Intent rezervasyonsayfasi = new Intent(MainActivity.this,Rezervasyonlar.class);
        startActivity(rezervasyonsayfasi);
    }
}
