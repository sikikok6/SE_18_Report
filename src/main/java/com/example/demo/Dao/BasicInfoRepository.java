package com.example.demo.Dao;

import com.example.demo.Model.BasicInfo_Front;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BasicInfoRepository extends JpaRepository<BasicInfoDao,String> {
    @Query(value = "SELECT basic_info_dao.*,message_dao.healthcondition,message_dao.riskcontact,message_dao.risklocation,message_dao.latitude,message_dao.longitude,message_dao.time FROM basic_info_dao INNER JOIN message_dao ON basic_info_dao.Openid = message_dao .Openid",nativeQuery = true)
    List<Object[]> findPL();
}
