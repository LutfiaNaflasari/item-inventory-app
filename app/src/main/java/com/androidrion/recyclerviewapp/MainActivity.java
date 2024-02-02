package com.androidrion.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{


    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;

    ArrayList<ItemModel> data;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        data = new ArrayList<>();

        for (int i = 0; i < MyItem.Headline.length; i++) {
            data.add(new ItemModel(
                    MyItem.Headline[i],
                    MyItem.Code[i],
                    MyItem.Description[i],
                    MyItem.Subhead[i],
                    MyItem.iconList[i]
            ));
        }

        showGrid();

    }

    private void showGrid() {
        initData();
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        GridAdapterView gridAdapterView = new GridAdapterView(data, this);
        recyclerView.setAdapter(gridAdapterView);
    }

    private void showList() {
        initData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        ListAdapterView listAdapterView = new ListAdapterView(data, this);
        recyclerView.setAdapter(listAdapterView);
    }


    private void initData() {
        this.data = new ArrayList<>();
        data.add(new ItemModel("CAIRAN INFUS NACL 0.9% 500ML", "AAM01","Biasa digunakan untuk cairan infus, untuk menggantikan cairan tubuh yang hilang, mengoreksi ketidak seimbangan elektrolit, dan menjaga tubuh agar tetap terhidrasi dengan baik.","13250", R.drawable.infus));
        data.add(new ItemModel("WWZ OneMed HOT WATER BAG", "AAM02","WWZ onemed ialah buli buli panas , alat kompress. Buli-buli yang diisi air panas untuk kompres bagian tubuh.","19500", R.drawable.kompres));
        data.add(new ItemModel("MASKER MEDIS KF94", "AAM03","Masker Medis 3D Mask Surgical didesign khusus, dengan high VFE, PFE & BFE, dan 4 lapis filter yang berfungsi untuk melindungi dari percikan air & nano partikel.","28000", R.drawable.masker));
        data.add(new ItemModel("NEBULIZER OMRON Compressor", "AAM04","Nebulizer Omron NE-C28 adalah sebuah alat yang digunakan untuk Terapi Gangguan Pernafasan, bekerja dengan menggunakan teknologi katup virtual (WT) tanpa menggunakan silikon.","680000", R.drawable.nebulizer));
        data.add(new ItemModel("PULSE OXIMETER FINGERTIP", "AAM05","Pulse Oximeter adalah alat yang digunakan untuk mengukur kadar oksigen dalam darah (SpO2), alat ini dilengkapi juga dengan pengukur detak jantung (heart rate) pasien.","105000", R.drawable.oximeter));
        data.add(new ItemModel("OneMed Disposable Syringe", "AAM06","OneMed Disposable Syringe with Needle ukuran 10 cc/ml merupakan alat suntik atau spuit yang sudah dilengkapi dengan jarum untuk menyuntikkan cairan.","135000", R.drawable.suntik));
        data.add(new ItemModel("OneMed Timbangan Badan", "AAM07","Pengukur berat badan injak model analaog jam, sekaligus ukur tinggi badan dengan pipa berskala, untuk segala usia.","1064490", R.drawable.timbangan));
        data.add(new ItemModel("Omron Automatic Blood Pressure", "AAM08","Tensimeter digital OMRON ini merupakan alat pengukur tekanan darah otomatis dilengkapi IntelliSense Technology yang dapat menyesuaikan tinggi rendah tensi pengguna yang diukur sehingga proses pengukuran lebih cepat, akurat dan nyaman bagi pengguna.","503000", R.drawable.tensi));
        data.add(new ItemModel("OneMed Thermometer", "AAM09","Thermometer Digital (bebas mercury) merk OneMed EKONOMIS, yang mudah digunakan, dan mempunyai akurasi tinggi, Layar LCD lebar, mudah dibaca, waktu pengukuran 60 detik.","26640", R.drawable.termometer));
        data.add(new ItemModel("OneMed Stethoscope", "AAM10","Alat medis untuk mendengarkan suara/ denyut jantung dalam tubuh pasien dewasa.","154290", R.drawable.tetoskop));
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("nama_brg", data.get(position).getNamabrg());
        intent.putExtra("kod_brg", data.get(position).getKodbrg());
        intent.putExtra("des_brg", data.get(position).getDesbrg());
        intent.putExtra("hrg_brg", data.get(position).getHrgbrg());
        intent.putExtra("gmbr_brg", data.get(position).getGambarbrg());

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_grid) {
            showGrid();
        } else if (item.getItemId() == R.id.menu_list) {
            showList();
        }
        return true;
    }
}
