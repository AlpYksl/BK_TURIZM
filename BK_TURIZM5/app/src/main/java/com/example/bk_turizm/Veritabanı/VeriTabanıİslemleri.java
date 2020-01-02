package com.example.bk_turizm.Veritabanı;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VeriTabanıİslemleri extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BK_Turizm";
    private static final int DATABSE_VERSION  = 1;
    private static long oneDayLongValue = 1000 * 60 * 60 * 24;
    public VeriTabanıİslemleri(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        updateDatabase(db, 0, DATABSE_VERSION);
    }

    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.setForeignKeyConstraintsEnabled(true);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+"YOLCULAR");
        db.execSQL("DROP TABLE IF EXISTS "+"HESAP");
        db.execSQL("DROP TABLE IF EXISTS "+"TRAVEL");
    }
    private void updateDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < 1) {

            db.execSQL(yolcuYarat());
            db.execSQL(hesapYarat());
            db.execSQL(yolculukYarat());
            insertYolcu(db, "Alp", "Yuksel", "5394110631");
            insertHesap(db, "alpuksl@gmail.com", "password", 1);
            insertYolculuk(db,"İstanbul","Ankara",tarihZaman(),Math.round(80.00), (int) Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Ankara",tarihZaman(),Math.round(80.00), (int) Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Ankara",tarihZaman(),Math.round(80.00), (int) Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","İzmir",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","İzmir",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","İzmir",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","İzmir",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","İzmir",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Adana",tarihZaman(),Math.round(180.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Adana",tarihZaman(),Math.round(180.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Adana",tarihZaman(),Math.round(180.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Adana",tarihZaman(),Math.round(180.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Edirne",tarihZaman(),Math.round(65.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Edirne",tarihZaman(),Math.round(65.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Edirne",tarihZaman(),Math.round(65.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Edirne",tarihZaman(),Math.round(65.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Şanlıurfa",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Şanlıurfa",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Şanlıurfa",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Şanlıurfa",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Şanlıurfa",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Konya",tarihZaman(),Math.round(150.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Konya",tarihZaman(),Math.round(150.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Konya",tarihZaman(),Math.round(150.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Bayburt",tarihZaman(),Math.round(170.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Bayburt",tarihZaman(),Math.round(170.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İstanbul","Bayburt",tarihZaman(),Math.round(170.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Ankara","İstanbul",tarihZaman(),Math.round(80.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Ankara","İstanbul",tarihZaman(),Math.round(80.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Ankara","İstanbul",tarihZaman(),Math.round(80.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Ankara","Trabzon",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Ankara","Trabzon",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Ankara","Trabzon",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Edirne","İstanbul",tarihZaman(),Math.round(65.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Edirne","İstanbul",tarihZaman(),Math.round(65.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Edirne","İstanbul",tarihZaman(),Math.round(65.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Edirne","Bodrum",tarihZaman(),Math.round(190.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Edirne","Bodrum",tarihZaman(),Math.round(190.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Edirne","Bodrum",tarihZaman(),Math.round(190.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Bayburt","İstanbul",tarihZaman(),Math.round(170.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Bayburt","İstanbul",tarihZaman(),Math.round(170.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Bayburt","İstanbul",tarihZaman(),Math.round(170.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Konya","İstanbul",tarihZaman(),Math.round(150.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Konya","İstanbul",tarihZaman(),Math.round(150.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Konya","İstanbul",tarihZaman(),Math.round(150.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Adana","İstanbul",tarihZaman(),Math.round(180.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Adana","İstanbul",tarihZaman(),Math.round(180.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Adana","İstanbul",tarihZaman(),Math.round(180.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İzmir","İstanbul",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İzmir","İstanbul",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"İzmir","İstanbul",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Şanlıurfa","İstanbul",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Şanlıurfa","İstanbul",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Şanlıurfa","İstanbul",tarihZaman(),Math.round(200.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Trabzon","Ankara",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Trabzon","Ankara",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Trabzon","Ankara",tarihZaman(),Math.round(120.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Bodrum","Edirne",tarihZaman(),Math.round(190.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Bodrum","Edirne",tarihZaman(),Math.round(190.00),(int)Math.round(0+Math.random()*5));
            insertYolculuk(db,"Bodrum","Edirne",tarihZaman(),Math.round(190.00),(int)Math.round(0+Math.random()*5));

        }
    }


    public String yolcuYarat() {
        return "CREATE TABLE YOLCULAR (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "FIRSTNAME TEXT COLLATE NOCASE, " +
                "LASTNAME TEXT COLLATE NOCASE, " +
                "PHONE TEXT," +
                "TRAVELID INTEGER," +
                "FOREIGN KEY(TRAVELID) REFERENCES TRAVEL(ID));";
    }
    public String hesapYarat() {
        return "CREATE TABLE HESAP (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "EMAIL TEXT, " +
                "PASSWORD TEXT, " +
                "ACCOUNT_CLIENT INTEGER, " +
                "FOREIGN KEY (ACCOUNT_CLIENT) REFERENCES YOLCULAR(_id));";
    }
    public String yolculukYarat()
    {
        return("CREATE TABLE TRAVEL(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "KALKIS TEXT NOT NULL," +
                "GİDİS TEXT NOT NULL,TARIH TEXT NOT NULL, FIYAT REAL, " +
                "KOLTUK_SAYISI INTEGER NOT NULL )");
    }
    public static void insertYolcu(SQLiteDatabase db, String firstName, String lastName, String phone) {
        ContentValues clientValues = new ContentValues();
        clientValues.put("FIRSTNAME", HelperUtilities.capitalize(firstName.toLowerCase()));
        clientValues.put("LASTNAME", HelperUtilities.capitalize(lastName.toLowerCase()));
        clientValues.put("PHONE", phone);
        db.insert("YOLCULAR", null, clientValues);
    }
    public static void insertHesap(SQLiteDatabase db, String email, String password, int clientID) {
        ContentValues accountValues = new ContentValues();
        accountValues.put("EMAIL", email);
        accountValues.put("PASSWORD", password);
        accountValues.put("ACCOUNT_CLIENT", clientID);
        db.insert("HESAP", null, accountValues);
    }
    public  void insertYolculuk(SQLiteDatabase db,String kalkis, String gidis, String tarih, double fiyat,
                               int koltuksayisi)
    {
            ContentValues cv = new ContentValues();
            cv.put("KALKIS",kalkis);
            cv.put("GİDİS", gidis);
            cv.put("TARIH",tarih);
            cv.put("FIYAT",fiyat);
            cv.put("KOLTUK_SAYISI",koltuksayisi);
            db.insert("TRAVEL", null, cv);
    }
    public static Cursor login(SQLiteDatabase db, String email, String password) {
        return db.query("HESAP", new String[]{"_id", "EMAIL", "PASSWORD", "ACCOUNT_CLIENT"},
                "EMAIL = ? AND PASSWORD = ? ", new String[]{email, password},
                null, null, null, null);
    }
    public List<String> veriListele(String kalkıs, String gidis){
        List<String> veriler = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            String[] stunlar = {"KALKIS","GİDİS","TARIH","FIYAT","KOLTUK_SAYISI"};
            Cursor cursor = db.query("TRAVEL", stunlar,"KALKIS=? AND GİDİS=?",new String[]{kalkıs,gidis},null,null,null);
            while (cursor.moveToNext()){
                veriler.add("Kalkış: "+cursor.getString(0)
                                + " \n "
                                +"Gidiş: " + cursor.getString(1)
                                + " \n "
                                + "Tarih: "+cursor.getString(2)
                                + " \n "
                                +"Fiyat: "+ cursor.getDouble(3)
                                + " TL\n"
                                + cursor.getInt(4)+"Kalan koltuk");
            }
        }catch (Exception e){
        }
        db.close();
        return veriler;
    }
    public static Cursor selectClient(SQLiteDatabase db, int clientID) {
        return db.query("YOLCULAR", null, " _id = ? ",
                new String[]{String.valueOf(clientID)}, null, null, null, null);
    }

    public static Cursor selectAccount(SQLiteDatabase db, String email) {
        return db.query("HESAP", null, " EMAIL = ? ",
                new String[]{email}, null, null, null, null);
    }
    public static Cursor selectClientID(SQLiteDatabase db, String firstName, String lastName,
                                        String phone) {
        return db.query("CLIENT", new String[]{"_id"},
                "FIRSTNAME = ? AND LASTNAME = ? AND PHONE = ? ",
                new String[]{firstName, lastName, phone},
                null, null, null, null);
    }
    public static String tarihZaman()//Saatleri ve tarihleri belirleme
    {
        java.sql.Timestamp s = new Timestamp((new java.util.Date()).getTime());
        long oneDayLongValue = 1000 * 60 * 60 * 24;
        Date now = new Date(s.getTime());
        Date afterDays = new Date(now.getTime() + ((int)(10+Math.random()*20)* oneDayLongValue));
        String gosterim = "dd/MM/yyyy - [hh:mm]";
        SimpleDateFormat sdf = new SimpleDateFormat(gosterim);
        return sdf.format(afterDays);
    }

}
