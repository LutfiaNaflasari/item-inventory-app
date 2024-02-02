package com.androidrion.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String namabrg = getIntent().getStringExtra("nama_brg");
        String kodbrg = getIntent().getStringExtra("kod_brg");
        String desbrg = getIntent().getStringExtra("des_brg");
        String hrgbrg = getIntent().getStringExtra("hrg_brg");
        int gmbrbrg = getIntent().getIntExtra("gmbr_brg", 0);

        TextView nama1 = findViewById(R.id.nmterima);
        TextView kode1 = findViewById(R.id.kodeterima);
        TextView des1 = findViewById(R.id.deskripsiterima);
        EditText total1 = findViewById(R.id.total_terimabeli);
        TextView hrg1 = findViewById(R.id.hargaterima);
        ImageView gambar1 = findViewById(R.id.gambarterima);
        EditText total_beli = findViewById(R.id.beli);
        EditText nmpembeli1 = findViewById(R.id.nama_beli);
        EditText pkjpembeli1 = findViewById(R.id.pekerjaan_beli);
        EditText almtpembeli1 =  findViewById(R.id.alamat_beli);
        Button tblinput = findViewById(R.id.tombolbeli);

        dbh = new DatabaseHelper(this);

        total_beli.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                try {
                    Double nilai1 = Double.parseDouble(total_beli.getText().toString());
                    Double nilai2 = Double.parseDouble(String.valueOf(hrgbrg));
                    DecimalFormat formatter = new DecimalFormat("0");
                    String hargajual = formatter.format(nilai1 * nilai2);

                    total1.setText("Rp" + hargajual);
                }catch (Exception e){
                    total1.setText("0");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        nama1.setText(namabrg);
        kode1.setText("Kode : " + kodbrg);
        des1.setText(desbrg);
        hrg1.setText("Harga : " + hrgbrg);
        gambar1.setImageResource(gmbrbrg);
    }

    public void beli(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

        String namabrg = getIntent().getStringExtra("nama_brg");
        String kodbrg = getIntent().getStringExtra("kod_brg");
        String desbrg = getIntent().getStringExtra("des_brg");
        String hrgbrg = getIntent().getStringExtra("hrg_brg");
        String satuanbrg = getIntent().getStringExtra("satuan_brg");
        int gmbrbrg = getIntent().getIntExtra("gmbr_brg", 0);
        EditText total_beli = findViewById(R.id.beli);
        EditText nmpembeli1 = findViewById(R.id.nama_beli);
        EditText pkjpembeli1 = findViewById(R.id.pekerjaan_beli);
        EditText almtpembeli1 =  findViewById(R.id.alamat_beli);

        Integer total = 100;
        Integer stok;
        stok = 100 - Integer.parseInt(String.valueOf(total_beli.getText()));
        dbh = new DatabaseHelper(this);
        dbh.tambah_data(kodbrg,gmbrbrg, namabrg, satuanbrg, total, hrgbrg, total_beli.getText().toString(), stok);

        int total2 = 0;
 //       int totalppn = 0;
        float total3 = 0;

        total2 = Integer.parseInt(String.valueOf(hrgbrg)) * Integer.parseInt(String.valueOf(total_beli.getText()));
        float ppn1 = (float) (0.1 * total2);
      //  totalppn = total2 * Float.parseFloat(Float.(ppn1));
        total3 = total2 + ppn1;
        intent.putExtra("totalppn", Float.toString(ppn1));
        intent.putExtra("totalbayar", Integer.toString(total2));
        intent.putExtra("totalsemua", Float.toString(total3));


        intent.putExtra("nmjual", namabrg);
        intent.putExtra("kodjual", kodbrg);
        intent.putExtra("desjual", desbrg);
        intent.putExtra("hargajual", hrgbrg);
        intent.putExtra("totalbeli", total_beli.getText().toString());
        intent.putExtra("namabeli", nmpembeli1.getText().toString());
        intent.putExtra("pkjbeli", pkjpembeli1.getText().toString());
        intent.putExtra("satuanbeli", satuanbrg);
        intent.putExtra("almtbeli", almtpembeli1.getText().toString());
        intent.putExtra("gmbrtmpil", gmbrbrg);
        startActivity(intent);
    }
}