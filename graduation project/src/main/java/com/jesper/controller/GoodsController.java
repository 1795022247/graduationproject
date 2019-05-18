package com.jesper.controller;

import com.github.pagehelper.PageInfo;
import com.jesper.aspect.service.FastefsClient;
import com.jesper.model.*;
import com.jesper.model.Goods;
import com.jesper.service.GoodsService;
import com.jesper.service.GoodsTypeService;
import com.jesper.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;

    @Autowired
    private GoodsService GoodsService;
    @Autowired
    private FastefsClient fastefsClient;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @RequestMapping("/toaddGoods")
    public String toaddGoods(Model model) {

        List<GoodsType> list=goodsTypeService.findAll();
        model.addAttribute("list",list);
        return "admin/hotel/premanager/addGoods";
    }


    @RequestMapping("/addGoods")
    @ResponseBody
    public RestResponse addGoods(Goods Goods, HttpServletRequest request) {



        try {
            Admin admin = (Admin) request.getSession().getAttribute("admin");

            System.out.println(admin);

            System.out.println(Goods);
            Goods.setHotolId(admin.getHotolId());
            GoodsService.insertSelective(Goods);


        }catch (Exception e){
            e.printStackTrace();
        }

        return RestResponse.success();
    }


    /*
   商品详情
   参数：商品id
    */
    @RequestMapping("/Goodsdetails")
    public String details(Integer id, Model model, HttpServletRequest request) {

        Goods Goods=GoodsService.selectByPrimaryKey(id);

        model.addAttribute("Goods",Goods);


        return "hotel/details";

    }

//    @GetMapping("list")
//    public String list(){
//        return "admin/hotel/premanager/Goodslist";
//    }


    @RequestMapping("/backGoodslist")
    public String backGoodslist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                               ServletRequest requests, Model model, HttpServletRequest request) {

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        /*
        查询商品列表；
         */
        PageInfo<Goods> pageInfoGoods=GoodsService.findByAdmin(admin,page,limit);
        System.out.println(pageInfoGoods);
        model.addAttribute("pageInfoGoods",pageInfoGoods);
        return "admin/hotel/premanager/Goodslist";
    }


    /*
    参数商品的id
     */
    @RequestMapping("/toupdataGoods")
    public String toupdataGoods(Model model,Integer id) {
        try {
            Goods Goods= GoodsService.selectByPrimaryKey(id);
            model.addAttribute("Goods",Goods);
        }catch (Exception e){
            e.printStackTrace();
        }


        return "admin/hotel/premanager/editGoods";
    }

    @RequestMapping("/updataGoods")
    @ResponseBody
    public RestResponse updataGoods(Model model,Goods Goods){

        try{
            GoodsService.updateByPrimaryKey(Goods);
            return RestResponse.success();
        }catch (Exception e){
            e.printStackTrace();
        }

        return RestResponse.failure("修改失败");
    }

    @RequestMapping("/delsGoods")
    @ResponseBody
    public  RestResponse del(Model model,Integer id){


        System.out.println(id);
        try{
            GoodsService.deleteByPrimaryKey(id);
            return RestResponse.success();
        }catch (Exception e){
            e.printStackTrace();
        }

        return RestResponse.failure("删除失败");
    }


    @RequestMapping("/findByLikeGoods")

    public String findByLikeGoods(Goods Goods,@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 ServletRequest requests, Model model, HttpServletRequest request){


        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        /*
        查询商品列表；
         */
        PageInfo<Goods> pageInfoGoods=GoodsService.findByGoods(admin,page,limit,Goods);
        System.out.println(pageInfoGoods);
        model.addAttribute("pageInfoGoods",pageInfoGoods);
        return "admin/hotel/premanager/Goodslist";
    }


}
