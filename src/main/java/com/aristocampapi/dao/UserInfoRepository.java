package com.aristocampapi.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aristocampapi.entity.UserInfo; 
  
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> { 
    Optional<UserInfo> findByLoginName(String username); 
    Optional<UserInfo> findByLoginNameAndUserStatus(String username,String status);
    UserInfo findById(int  userId);
    
}