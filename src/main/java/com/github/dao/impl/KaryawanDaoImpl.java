package com.github.dao.impl;

import com.github.model.Karyawan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.github.dao.KaryawanDao;
import org.springframework.stereotype.Component;

@Component
public class KaryawanDaoImpl implements KaryawanDao {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Karyawan> findAll() {
        return jdbcTemplate.query("SELECT id,nama,tanggal_lahir,gaji FROM karyawan", new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int i) throws SQLException {
                Karyawan karyawan = new Karyawan();
                karyawan.setId(rs.getInt("id"));
                karyawan.setNama(rs.getString("nama"));
                karyawan.setTanggalLahir(rs.getDate("tanggal_lahir"));
                karyawan.setGaji(rs.getBigDecimal("gaji"));
                return karyawan;
            }
        });
    }

    @Override
    public Karyawan findById(Integer id) {
        return jdbcTemplate.queryForObject("SELECT id,nama,tanggal_lahir,gaji FROM karyawan WHERE id=?", new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int i) throws SQLException {
                Karyawan karyawan = new Karyawan();
                karyawan.setId(rs.getInt("id"));
                karyawan.setNama(rs.getString("nama"));
                karyawan.setTanggalLahir(rs.getDate("tanggal_lahir"));
                karyawan.setGaji(rs.getBigDecimal("gaji"));
                return karyawan;
            }
        },id);
    }

    @Override
    public void deleteById(Integer id) {
        jdbcTemplate.update("DELETE from karyawan WHERE id=?",id);
    }

    @Override
    public void add(Karyawan karyawan) {
        jdbcTemplate.update("INSERT INTO karyawan(nama,tanggal_lahir,gaji) VALUES(?,?,?)", new Object[]{karyawan.getNama(),karyawan.getTanggalLahir(),karyawan.getGaji()});
    }

    @Override
    public void update(Karyawan karyawan) {
        jdbcTemplate.update("UPDATE karyawan SET nama=?,tanggal_lahir=?,gaji=? WHERE id=?",new Object[]{karyawan.getNama(),karyawan.getTanggalLahir(),karyawan.getGaji(),karyawan.getId()});
    }
    
}
