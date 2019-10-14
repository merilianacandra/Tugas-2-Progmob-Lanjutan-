package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MahasiswaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertMahasiswa(Mahasiswa mahasiswa);

    @Update
    int updateMahasiswa(Mahasiswa mahasiswa);

    @Delete
    int deleteMahasiswa(Mahasiswa mahasiswa);

    @Query("SELECT * FROM tb_mahasiswa")
    Mahasiswa[] selectAllMahasiswas();

    @Query("SELECT * FROM tb_mahasiswa WHERE id_mhs = :id LIMIT 1")
    Mahasiswa selectMahasiswaDetail(int id);
}
