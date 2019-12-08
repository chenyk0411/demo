package com.example.demo.service;

import com.example.demo.beans.entity.ImmeEmp;

import java.util.List;

public interface EmpService {
    /**
     * 查询所有的用户
     * @return
     */
    List<ImmeEmp> getAllEmp();
}
