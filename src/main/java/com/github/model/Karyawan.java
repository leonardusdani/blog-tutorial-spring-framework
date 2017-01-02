package com.github.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

public class Karyawan implements Serializable{ 
    
    private Integer id;
    private String nama;
    private Date tanggalLahir;
    private BigDecimal gaji;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public BigDecimal getGaji() {
        return gaji;
    }

    public void setGaji(BigDecimal gaji) {
        this.gaji = gaji;
    }
    
}
