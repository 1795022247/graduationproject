package com.jesper.controller;

import com.jesper.model.Hotol;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HotolController {

    /*
   用户修改密码
   参数：
    */
    @RequestMapping(value = "toaddhotel",method = RequestMethod.GET)
    public String  toaddhotol( Model model, HttpServletRequest request){


        return "";
    }
    /*
    添加酒店
     */
    @RequestMapping(value = "addhotel")
    public String  addhotol(Hotol hotol, Model model, HttpServletRequest request){


        return "";
    }

}
