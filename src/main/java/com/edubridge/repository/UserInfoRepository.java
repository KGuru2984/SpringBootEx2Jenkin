package com.edubridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edubridge.models.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>
{
	UserInfo findByUserinfoid(Integer userid);
}
