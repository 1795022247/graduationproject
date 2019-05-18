package com.jesper.controller;

import com.jesper.model.Admin;
import com.jesper.service.AdminService;
import com.jesper.util.RestResponse;
import com.jesper.util.RoundRobin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

@Controller

public class AdminController {

    @Autowired
    private AdminService adminService;

    /*
    跳转到登录界面
     */
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "admin/hotel/login";
    }

    /*
    执行登陆
    参数 Admin 对象 admin
  */
    @RequestMapping("/Login")
    @ResponseBody
    public RestResponse Login(Admin admin, HttpSession session, HttpServletRequest request) {

        Admin admin1 = adminService.ToLoginfindByAdmin(admin);
        System.out.println(admin1);
        if (admin1 != null) {

            request.getSession().setAttribute("admin", admin1);
            // session.setAttribute("admin", admin1);
            Map<String, Object> map = new HashMap<>();
            map.put("url", "index");
            return RestResponse.success("登录成功").setData(map);

        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("url", "toLogin");
            request.setAttribute("errorInfo", "用户名或密码错误！");
            return RestResponse.success("密码错误").setData(map);

        }


    }

    /*
        退出登陆操作
        清除session
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "admin/hotel/login";
    }

    /*
    来到主页
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");

        //
        //
        // CopyOnWriteArrayList
        try {
            if (admin.getId() != null && !admin.getId().equals("")) {
                return "admin/hotel/index";
            } else {
                return "admin/hotel/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "admin/hotel/login";
        }


    }

    /*
    映射到/hotolList.html
     */
    @RequestMapping("/hotolList")
    public String hotolList() {


        return "hotolList";
    }

    @RequestMapping("/red")
    @ResponseBody
    public String red() {

      //  ReentrantLock

        System.out.println(new RoundRobin().testRoundRobin());
        return new RoundRobin().testRoundRobin();
    }


}
