package com.example.demo.util;

import com.example.demo.beans.Result;
import com.example.demo.beans.entity.ImmeUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CommUtil {
    public static boolean isListNotBlank(List list){
        return list != null && list.size() > 0;
    }

    public static boolean checkSession(HttpServletRequest request){
        if(request == null){
            return false;
        }

        ImmeUser user = (ImmeUser) request.getSession().getAttribute(Constant.KEY_CURRENTUSER);
        if(user == null){
            return false;
        }

        return true;
    }

    public static void responseData(HttpServletResponse response, Result result){
        response.setContentType("application/json;charset=UTF-8");
    }
}
