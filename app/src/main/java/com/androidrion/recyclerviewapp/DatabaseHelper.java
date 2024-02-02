package com.androidrion.recyclerviewapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String nama_db="DB_PAAK2";
    public final static String nama_table="AlatKesehatan";

    public final static String field_01="kode_barang";
    public final static String field_02="gambar_barang";
    public final static String field_03="nama_barang";
    public final static String field_04="satuan";
    public final static String field_05="jumlah_stok";
    public final static String field_06="harga";
    public final static String field_07="terjual";
    public final static String field_08="sisa";

    public DatabaseHelper(Context context) {
        super(context, nama_db, null, 1);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + nama_table + "(kode_barang text primary key,gambar_barang int, nama_barang text, satuan text, jumlah_stok text, harga int,terjual text, sisa int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + nama_table);
        onCreate(sqLiteDatabase);
    }

    public void tambah_data(String kode_barang, int gambar_barang, String nama_barang, String satuan, Integer jumlah_stok, String harga, String terjual, Integer sisa) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(field_01, kode_barang);
        contentValues.put(field_02, gambar_barang);
        contentValues.put(field_03, nama_barang);
        contentValues.put(field_04, satuan);
        contentValues.put(field_05, jumlah_stok);
        contentValues.put(field_06, harga);
        contentValues.put(field_07, terjual);
        contentValues.put(field_08, sisa);

        db.insert(nama_table, null, contentValues);
    }

    public Cursor baca_data() {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from " + nama_table, null);
        return res;
    }
}
