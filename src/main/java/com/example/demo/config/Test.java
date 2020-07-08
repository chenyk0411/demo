package com.example.demo.config;

import com.example.demo.util.HtmlToPDFUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args){
        /*User u1 = new User("admin1",25);
        User u2 = new User("admin2",22);
        User u3 = new User("admin3",29);
        User u4 = new User("admin4",20);
        User u5 = new User("admin5",28);
        User[] users = new User[]{u1,u2,u3,u4,u5};
        for(User user : users){
            System.out.println(user.getUserName()+"的年龄:"+user.getAge());
        }
        System.out.println("----排序后------");
        Arrays.sort(users);
        for(User user : users){
            System.out.println(user.getUserName()+"的年龄:"+user.getAge());
        }*/

        String src = "https://www.highcharts.com/demo/line-basic/grid-light";
        String path = "d:\\test.pdf";
        try {
            HtmlToPDFUtil.htmlToPDF(src,path);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
