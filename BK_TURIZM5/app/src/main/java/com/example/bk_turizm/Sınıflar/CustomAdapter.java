package com.example.bk_turizm.Sınıflar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.bk_turizm.R;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private Sehir.Container model;

    public CustomAdapter(Context context, Sehir.Container model) {
        this.context = context;
        this.model = model;
    }

    @Override
    public int getCount() {
       return model.getVector().size();
    }

    @Override
    public Object getItem(int position) {
         return model.getVector().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Sehir sehir = (Sehir) getItem(position);
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        LinearLayout pnlItem = (LinearLayout) layoutInflater.inflate(R.layout.sehir_dizilim,null);

        TextView txtIsim = (TextView) pnlItem.findViewById(R.id.txtIsim);
        txtIsim.setText(sehir.getIsim());

        ImageView imageView = (ImageView) pnlItem.findViewById(R.id.ımgGorsel);
        Resources res = context.getResources();
        Drawable drw = res.getDrawable(sehir.getGorsel());
        imageView.setImageDrawable(drw);

        return pnlItem;
    }
}
