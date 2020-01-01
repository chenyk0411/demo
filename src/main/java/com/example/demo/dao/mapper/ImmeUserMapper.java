package com.example.demo.dao.mapper;

import com.example.demo.beans.entity.ImmeUser;
import com.example.demo.beans.entity.ImmeUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImmeUserMapper {
    long countByExample(ImmeUserExample example);

    int deleteByExample(ImmeUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(ImmeUser record);

    int insertSelective(ImmeUser record);

    List<ImmeUser> selectByExample(ImmeUserExample example);

    ImmeUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ImmeUser record, @Param("example") ImmeUserExample example);

    int updateByExample(@Param("record") ImmeUser record, @Param("example") ImmeUserExample example);

    int updateByPrimaryKeySelective(ImmeUser record);

    int updateByPrimaryKey(ImmeUser record);
}