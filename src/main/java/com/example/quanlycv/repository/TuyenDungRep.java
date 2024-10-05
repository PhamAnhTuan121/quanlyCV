package com.example.quanlycv.repository;

import com.example.quanlycv.entity.QlTuyenDung;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TuyenDungRep extends JpaRepository<QlTuyenDung,Integer> {

    Page<QlTuyenDung> findAll(Pageable pageable);
//    @Query("SELECT t FROM QlTuyenDung t WHERE " +
//            "LOWER(t.maDot) LIKE %:keyword% OR " +
//            "LOWER(t.tenDot) LIKE %:keyword% ")
//           // "LOWER(t.noiDung) LIKE %:keyword%")
//
//    Page<QlTuyenDung> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);


    @Query("SELECT td FROM QlTuyenDung td WHERE td.maDot LIKE %?1% OR td.tenDot LIKE %?1% OR td.noiDung LIKE %?1%   ")
    Page<QlTuyenDung> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

//    List<QlTuyenDung> findByMaDotContainingOrTenDotContainingOrNoiDungContaining(String maDot, String tenDot, String noiDung, Date deadline);
}
