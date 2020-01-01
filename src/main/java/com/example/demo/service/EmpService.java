package com.example.demo.service;

import com.example.demo.beans.Result;
import com.example.demo.beans.entity.ImmeEmp;
import com.example.demo.beans.entity.ImmeUser;

import java.util.List;

public interface EmpService {
    /**
     * 查询所有的用户
     * @return
     */
    List<ImmeEmp> getAllEmp();

    /**
     * 登录验证
     * @param user
     * @return
     */
    Result login(ImmeUser user);
}
