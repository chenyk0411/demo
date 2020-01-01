package com.example.demo.service.impl;

import com.example.demo.beans.Result;
import com.example.demo.beans.entity.ImmeEmp;
import com.example.demo.beans.entity.ImmeUser;
import com.example.demo.beans.entity.ImmeUserExample;
import com.example.demo.dao.mapper.ImmeEmpMapper;
import com.example.demo.dao.mapper.ImmeUserMapper;
import com.example.demo.service.EmpService;
import com.example.demo.util.CommUtil;
import com.example.demo.util.Constant;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Log4j2
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    ImmeEmpMapper empMapper;

    @Autowired
    ImmeUserMapper userMapper;

    @Autowired
    HttpServletRequest request;

    @Override
    public List<ImmeEmp> getAllEmp() {
        return empMapper.getAll();
    }

    @Override
    public Result login(ImmeUser user) {
        ImmeUserExample example = new ImmeUserExample();
        ImmeUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());

        List<ImmeUser> users = userMapper.selectByExample(example);
        if(CommUtil.isListNotBlank(users)){
            request.getSession().setAttribute(Constant.KEY_CURRENTUSER,users.get(0));
            request.getSession().setMaxInactiveInterval(Constant.SESSION_TIMEOUT);

            return new Result(true);
        }
        else {
            return new Result(false,"用户名或密码错误");
        }
    }
}
