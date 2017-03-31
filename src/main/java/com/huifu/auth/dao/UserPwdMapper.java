package com.huifu.auth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.huifu.auth.entity.UserPwd;
import com.huifu.auth.entity.UserPwdExample;

@Repository
public interface UserPwdMapper {
    long countByExample(UserPwdExample example);

    int deleteByExample(UserPwdExample example);

    int deleteByPrimaryKey(Long uid);

    int insert(UserPwd record);

    int insertSelective(UserPwd record);

    List<UserPwd> selectByExample(UserPwdExample example);

    UserPwd selectByPrimaryKey(Long uid);

    int updateByExampleSelective(@Param("record") UserPwd record, @Param("example") UserPwdExample example);

    int updateByExample(@Param("record") UserPwd record, @Param("example") UserPwdExample example);

    int updateByPrimaryKeySelective(UserPwd record);

    int updateByPrimaryKey(UserPwd record);
}