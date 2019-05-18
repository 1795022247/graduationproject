package com.jesper.controller;

import com.jesper.model.GoodsType;
import com.jesper.service.GoodsTypeService;
import com.jesper.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GoodsTypeController {




    @Autowired
    private GoodsTypeService goodsTypeService;


    @RequestMapping("/addGoodsType")
    @ResponseBody
    public RestResponse addGoodType(GoodsType goodsType, HttpServletRequest request) {

        try {

            goodsTypeService.insertSelective(goodsType);

        }catch (Exception e){
            e.printStackTrace();
        }

        return RestResponse.success();
    }


    @RequestMapping("/toaddGoodsType")
    public String toaddRoom(Model model) {
        return "admin/hotel/premanager/goodsType";
    }






    @RequestMapping("/toupdataGoodsType")
    public String toupdataRoom(Model model,Integer id) {
        try {
          GoodsType goodsType= goodsTypeService.selectByPrimaryKey(id);
            model.addAttribute("goodsType",goodsType);
        }catch (Exception e){
            e.printStackTrace();
        }


        return "admin/hotel/premanager/editroom";
    }

    @RequestMapping("/updataGoodsType")
    @ResponseBody
    public RestResponse updataRoom(Model model,GoodsType goodsType){

        try{
           goodsTypeService.updateByPrimaryKey(goodsType);
            return RestResponse.success();
        }catch (Exception e){
            e.printStackTrace();
        }

        return RestResponse.failure("修改失败");
    }

    @RequestMapping("/delsGoodsType")
    @ResponseBody
    public  RestResponse del(Model model,Integer id){


        System.out.println(id);
        try{
            goodsTypeService.deleteByPrimaryKey(id);
            return RestResponse.success();
        }catch (Exception e){
            e.printStackTrace();
        }

        return RestResponse.failure("删除失败");
    }




    @RequestMapping("/findByLikeGoodsType")

    public String findByLikeRoom(GoodsType goodsType, @RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 ServletRequest requests, Model model, HttpServletRequest request){




            List<GoodsType> goodsTypeList=goodsTypeService.findAll();

            model.addAttribute("goodsTypeList",goodsTypeList);


        return "admin/hotel/premanager/goopTypelist";
    }












}
