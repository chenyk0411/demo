package com.example.demo.dao.mapper;

import com.example.demo.beans.entity.ImmeEmp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ImmeEmpMapper {
    int deleteByPrimaryKey(Short empno);

    int insert(ImmeEmp record);

    int insertSelective(ImmeEmp record);

    ImmeEmp selectByPrimaryKey(Short empno);

    int updateByPrimaryKeySelective(ImmeEmp record);

    int updateByPrimaryKey(ImmeEmp record);

    List<ImmeEmp> getAll();
}