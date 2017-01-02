package com.github;

import com.github.dao.KaryawanDao;
import com.github.model.Karyawan;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogTutorialSpringFrameworkApplicationTests {

    @Autowired
    KaryawanDao karyawanDao;
    
	@Test
	public void contextLoads() {
	}
        
        @Test
        public void KaryawanDaoTest(){
            //test untuk menambahkan karyawan baru
            Karyawan karyawanBaru = new Karyawan();
            karyawanBaru.setNama("Adi Putra");
            karyawanBaru.setTanggalLahir(Date.valueOf("1992-07-14"));
            karyawanBaru.setGaji(BigDecimal.valueOf(5000000.00));
            karyawanDao.add(karyawanBaru);
            Karyawan karyawanEdit = karyawanDao.findById(3);
            Assert.assertEquals("Adi Putra", karyawanEdit.getNama());
            
            //test untuk edit karyawan
            karyawanEdit.setNama("Adi Luhur");
            karyawanDao.update(karyawanEdit);
            Assert.assertNotEquals("Adi Putra", karyawanEdit.getNama());
            
            //test untuk mendapatkan list karyawan
            List<Karyawan> listKaryawan = karyawanDao.findAll();
            Assert.assertTrue(listKaryawan.size()>2);
            
            //test untuk menghapus karyawan
            karyawanDao.deleteById(3);
            listKaryawan = karyawanDao.findAll();
            Assert.assertFalse(listKaryawan.size()>2);
        }

}
