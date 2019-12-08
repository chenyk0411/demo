package com.example.demo.service.impl;

import com.example.demo.beans.entity.ImmeEmp;
import com.example.demo.dao.mapper.ImmeEmpMapper;
import com.example.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    ImmeEmpMapper empMapper;

    @Override
    public List<ImmeEmp> getAllEmp() {
        return empMapper.getAll();
    }
}
