package com.example.bk_turizm;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

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

    public void rezerv_Click(View view) {


    }
}
