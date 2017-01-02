package com.github.dao;

import com.github.model.Karyawan;
import java.util.List;

public interface KaryawanDao {
    
    List<Karyawan> findAll();
    
    Karyawan findById(Integer id);
    
    void deleteById(Integer id);
    
    void add(Karyawan karyawan);
    
    void update(Karyawan karyawan);
    
}
