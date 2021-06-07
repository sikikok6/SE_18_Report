package com.example.demo.Dao;

import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplyRepository extends JpaRepository<ApplyDao,ApplyID> {

    @Query(value = "select count(*) from apply_dao where openid = :Id group by openid",nativeQuery = true)
    Integer CountSeq(@Param("Id") String openid);

    @Query(value = "SELECT basic_info_dao.openid,basic_info_dao.comid,basic_info_dao.name,basic_info_dao.sex,basic_info_dao.tel," +
            "       apply_dao.seq,apply_dao.location,apply_dao.time,apply_dao.type,apply_dao.reason,apply_dao.starttime,apply_dao.endtime," +
            "       apply_dao.schedule,apply_dao.traffictools,apply_dao.destination,apply_dao.permit" +
            "       FROM basic_info_dao INNER JOIN apply_dao ON basic_info_dao.Openid = apply_dao .Openid",nativeQuery = true)
    List<Object[]> GetApplyInfo();

    @Query(value = "SELECT basic_info_dao.openid,basic_info_dao.comid,basic_info_dao.name,basic_info_dao.sex,basic_info_dao.tel," +
            "       apply_dao.seq,apply_dao.location,apply_dao.time,apply_dao.type,apply_dao.reason,apply_dao.starttime,apply_dao.endtime," +
            "       apply_dao.schedule,apply_dao.traffictools,apply_dao.destination,apply_dao.permit" +
            "       FROM basic_info_dao,apply_dao where apply_dao.openid = :id and basic_info_dao.openid = :id",nativeQuery = true)
    List<Object[]> GetMyApplyInfo(@Param("id") String Openid);



}
