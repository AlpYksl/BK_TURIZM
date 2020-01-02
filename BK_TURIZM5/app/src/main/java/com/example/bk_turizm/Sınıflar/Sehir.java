package com.example.bk_turizm.Sınıflar;

import androidx.annotation.NonNull;

import com.example.bk_turizm.R;

import java.util.Vector;

public class Sehir {
    private String isim;
    private int gorsel;

    public Sehir(String isim, int gorsel) {
        this.isim = isim;
        this.gorsel = gorsel;
    }

    public String getIsim() {
        return isim;
    }

    public int getGorsel() {
        return gorsel;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setGorsel(int gorsel) {
        this.gorsel = gorsel;
    }

    public static class Container{
        private Vector<Sehir> vector;

        public Vector<Sehir> getVector() {
            return vector;
        }
        public Container()
        {
            this.vector = new Vector<Sehir>(3);
            vector.add(new Sehir("İstanbul", R.drawable.istanbul));
            vector.add(new Sehir("Ankara",R.drawable.ankara));
            vector.add(new Sehir("Adana",R.drawable.adana));
            vector.add(new Sehir("İzmir",R.drawable.izmir));
            vector.add(new Sehir("Şanlıurfa",R.drawable.sanliurfa));
            vector.add(new Sehir("Ağrı",R.drawable.agri));
            vector.add(new Sehir("Bayburt",R.drawable.bayburt));
            vector.add(new Sehir("Edirne",R.drawable.edirne));
            vector.add(new Sehir("Mersin",R.drawable.mersin));
            vector.add(new Sehir("Bursa",R.drawable.bursa));
            vector.add(new Sehir("Rize",R.drawable.rize));
            vector.add(new Sehir("Trabzon",R.drawable.trabzon));
            vector.add(new Sehir("Sakarya",R.drawable.sakarya));
            vector.add(new Sehir("Diyarbakır",R.drawable.diyarbakir));
            vector.add(new Sehir("Konya",R.drawable.konya));
            vector.add(new Sehir("Kars",R.drawable.kars));
            vector.add(new Sehir("Ordu",R.drawable.ordu));
            vector.add(new Sehir("Gaziantep",R.drawable.gaziantep));
            vector.add(new Sehir("Bodrum",R.drawable.bodrum));
            vector.add(new Sehir("Çanakkale",R.drawable.canakkale));

        }
    }

    @NonNull
    @Override
    public String toString() {
        return this.isim;
    }
}
