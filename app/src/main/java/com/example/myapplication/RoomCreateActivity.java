package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class RoomCreateActivity extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswadb").build();

        final EditText etNamaMahasiswa = findViewById(R.id.et_namamahasiswa);
        final EditText etNimMahasiswa = findViewById(R.id.et_nimmahasiswa);
        final EditText etJurusanMahasiswa = findViewById(R.id.et_jurusanmahasiswa);
        Button btSubmit = findViewById(R.id.bt_submit);

        final Mahasiswa mahasiswa = (Mahasiswa) getIntent().getSerializableExtra("data");

        if(mahasiswa!=null){
            etNamaMahasiswa.setText(mahasiswa.getNamaMahasiswa());
            etNimMahasiswa.setText(mahasiswa.getNimMahasiswa());
            etJurusanMahasiswa.setText(mahasiswa.getJurusanMahasiswa());
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mahasiswa.setNamaMahasiswa(etNamaMahasiswa.getText().toString());
                    mahasiswa.setNimMahasiswa(etNimMahasiswa.getText().toString());
                    mahasiswa.setJurusanMahasiswa(etJurusanMahasiswa.getText().toString());

                    updateMahasiswa(mahasiswa);
                }
            });
        }else{
            btSubmit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Mahasiswa b = new Mahasiswa();
                    b.setNamaMahasiswa(etNamaMahasiswa.getText().toString());
                    b.setNimMahasiswa(etNimMahasiswa.getText().toString());
                    b.setJurusanMahasiswa(etJurusanMahasiswa.getText().toString());
                    insertData(b);
                }
            });
        }
    }


    @SuppressLint("StaticFieldLeak")
    private void updateMahasiswa(final Mahasiswa mahasiswa){
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids){
                long status = db.mahasiswaDAO().updateMahasiswa(mahasiswa);
                return status;
            }

            @Override
            protected void onPostExecute(Long status){
                Toast.makeText(RoomCreateActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    private void insertData(final Mahasiswa mahasiswa){

        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids){
                long status = db.mahasiswaDAO().insertMahasiswa(mahasiswa);
                return status;
            }

            @Override
            protected void onPostExecute(Long status){
                Toast.makeText(RoomCreateActivity.this, "status row "+status, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, RoomCreateActivity.class);
    }
}
