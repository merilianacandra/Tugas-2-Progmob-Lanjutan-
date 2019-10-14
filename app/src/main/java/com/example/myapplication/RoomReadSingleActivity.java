package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RoomReadSingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        EditText etNama = findViewById(R.id.et_namamahasiswa);
        EditText etMerk = findViewById(R.id.et_nimmahasiswa);
        EditText etHarga = findViewById(R.id.et_jurusanmahasiswa);
        Button btSubmit = findViewById(R.id.bt_submit);

        etNama.setEnabled(false);
        etMerk.setEnabled(false);
        etHarga.setEnabled(false);
        btSubmit.setVisibility(View.GONE);

        Mahasiswa mahasiswa = (Mahasiswa) getIntent().getSerializableExtra("data");
        if(mahasiswa!=null){
            etNama.setText(mahasiswa.getNamaMahasiswa());
            etMerk.setText(mahasiswa.getNimMahasiswa());
            etHarga.setText(mahasiswa.getJurusanMahasiswa());
        }

    }

    public static Intent getActIntent(Activity activity) {

        return new Intent(activity, RoomReadSingleActivity.class);
    }

}
