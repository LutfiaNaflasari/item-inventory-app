package com.androidrion.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    ImageView gbr;
    TextView namapbl, pkjpbl, almtpbl, nama, kode, beli, harga, totalbyr, totalppn, totalsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        gbr = findViewById(R.id.gambarterima);
        namapbl = findViewById(R.id.nmpembelijual);
        pkjpbl = findViewById(R.id.pkjpembelijual);
        almtpbl = findViewById(R.id.almtpembelijual);
        nama = findViewById(R.id.namajual);
        kode = findViewById(R.id.kodejual);
        beli = findViewById(R.id.totaljual);
        harga = findViewById(R.id.hargajual);
        totalbyr = findViewById(R.id.totalharga);
        totalppn = findViewById(R.id.totalpajak1);
        totalsm = findViewById(R.id.totalsemua1);


        int gmbr1 = getIntent().getIntExtra("gmbrtmpil", 0);
        String nmpembeli2 = getIntent().getStringExtra("namabeli");
        String pkjpembeli2 = getIntent().getStringExtra("pkjbeli");
        String almtpembeli2 = getIntent().getStringExtra("almtbeli");
        String namabrg1 = getIntent().getStringExtra("nmjual");
        String kodbrg1 = getIntent().getStringExtra("kodjual");
        String hrgbrg1 = getIntent().getStringExtra("hargajual");
        String total1 = getIntent().getStringExtra("totalbeli");
        String bayarbrg = getIntent().getStringExtra("totalbayar");
        String ppnpajak = getIntent().getStringExtra("totalppn");
        String bayarsemua = getIntent().getStringExtra("totalsemua");

        gbr.setImageResource(gmbr1);
        namapbl.setText("Nama : " + nmpembeli2);
        pkjpbl.setText("Pekerjaan : " + pkjpembeli2);
        almtpbl.setText("Alamat : " + almtpembeli2);
        nama.setText("Beli Unit : " + namabrg1);
        kode.setText("Kode : " + kodbrg1);
        harga.setText("Harga Barang : Rp " + hrgbrg1);
        beli.setText("Total Barang : " + total1 + " produk");
        totalbyr.setText("Total Harga Barang : Rp " + bayarbrg);
        totalppn.setText("PPN : " + ppnpajak);
        totalsm.setText("Total Pembayaran : Rp " + bayarsemua );
    }
}