package com.example.myapplication;

import java.io.Serializable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tb_mahasiswa")
public class Mahasiswa implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int id_mhs;

    @ColumnInfo(name = "nama_mahasiswa")
    public String namaMahasiswa;

    @ColumnInfo(name = "nim_mahasiswa")
    public String nimMahasiswa;

    @ColumnInfo(name = "jurusan_mahasiswa")
    public String jurusanMahasiswa;

    public int getId_mhs(){
        return id_mhs;
    }
    public void setId_mhs(int id_mhs){
        this.id_mhs = id_mhs;
    }

    public String getNamaMahasiswa(){
        return namaMahasiswa;
    }
    public void setNamaMahasiswa(String namaMahasiswa){
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNimMahasiswa(){
        return  nimMahasiswa;
    }
    public void setNimMahasiswa(String nimMahasiswa){
        this.nimMahasiswa = nimMahasiswa;
    }

    public String getJurusanMahasiswa(){
        return jurusanMahasiswa;
    }
    public void setJurusanMahasiswa(String jurusanMahasiswa){
        this.jurusanMahasiswa = jurusanMahasiswa;
    }
}
