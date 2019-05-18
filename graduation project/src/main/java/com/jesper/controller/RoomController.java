package com.jesper.controller;

import com.github.pagehelper.PageInfo;
import com.jesper.aspect.service.FastefsClient;
import com.jesper.model.Admin;
import com.jesper.model.Room;
import com.jesper.service.RoomService;
import com.jesper.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RoomController {

    @Value("${file.path.head:http://119.29.230.78:9999/}")
    private String pathHead;

    @Autowired
    private RoomService roomService;
    @Autowired
    private FastefsClient fastefsClient;

    /*
    映射到 添加酒店房间页面
     */
    @RequestMapping("/toaddRoom")
    public String toaddRoom(Model model) {
        return "admin/hotel/premanager/addroom";
    }

    /*
    万成添加房间的操作
    返回值json

     */
    @RequestMapping("/addRoom")
    @ResponseBody
    public RestResponse addRoom(Room room, HttpServletRequest request) {


        try {
            Admin admin = (Admin) request.getSession().getAttribute("admin");

            System.out.println(admin);

            System.out.println(room);
            room.setHotolId(admin.getHotolId());
            roomService.insertSelective(room);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.success();
    }

    /*
    上传的图片操作
    上传到 fastDsf 操作
     */
    @PostMapping("upload")
    @ResponseBody
    public RestResponse uploadFile(@RequestParam("file") MultipartFile file) {

        System.out.println("----------------");
        if (file == null) {
            return RestResponse.failure("上传文件为空 ");
        }
        Map m = new HashMap();
        try {

            String filename = pathHead + fastefsClient.uploFile(file);
            m.put("url", filename);
            m.put("name", file.getOriginalFilename());
            System.out.println(filename);
        } catch (Exception e) {
            e.printStackTrace();
            return RestResponse.failure(e.getMessage());
        }
        return RestResponse.success().setData(m);
    }

    /*
   房间详情
   参数：房间id
    */
    @RequestMapping("/roomdetails")
    public String details(Integer id, Model model, HttpServletRequest request) {

        Room room = roomService.selectByPrimaryKey(id);

        model.addAttribute("room", room);


        return "hotel/details";

    }

//    @GetMapping("list")
//    public String list(){
//        return "admin/hotel/premanager/roomlist";
//    }

    /*
    客房信息管理模块
     */
    @RequestMapping("/backroomlist")
    public String backroomlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                               ServletRequest requests, Model model, HttpServletRequest request) {

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        /*
        查询房间列表；
         */
        PageInfo<Room> pageInforoom = roomService.findByAdmin(admin, page, limit);
        System.out.println(pageInforoom);
        model.addAttribute("pageInforoom", pageInforoom);
        return "admin/hotel/premanager/roomlist";
    }


    /*
    参数房间的id
     */
    @RequestMapping("/toupdataRoom")
    public String toupdataRoom(Model model, Integer id) {
        try {
            Room room = roomService.selectByPrimaryKey(id);
            model.addAttribute("room", room);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return "admin/hotel/premanager/editroom";
    }

    /*
    修改房间操作
     */
    @RequestMapping("/updataRoom")
    @ResponseBody
    public RestResponse updataRoom(Model model, Room room,HttpServletRequest request) {

        try {
            Admin admin = (Admin) request.getSession().getAttribute("admin");
            room.setHotolId(admin.getHotolId());
            roomService.updateByPrimaryKey(room);
            return RestResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.failure("修改失败");
    }

    /*
    删除房间操作
     */
    @RequestMapping("/delsRoom")
    @ResponseBody
    public RestResponse del(Model model, Integer id) {


        System.out.println(id);
        try {
            roomService.deleteByPrimaryKey(id);
            return RestResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.failure("删除失败");
    }

    /*
    模糊查询操作
     */
    @RequestMapping("/findByLikeRoom")

    public String findByLikeRoom(Room room, @RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 ServletRequest requests, Model model, HttpServletRequest request) {


        Admin admin = (Admin) request.getSession().getAttribute("admin");
        System.out.println(admin);
        /*
        查询房间列表；
         */
        PageInfo<Room> pageInforoom = roomService.findByRoom(admin, page, limit, room);
        System.out.println(pageInforoom);
        model.addAttribute("pageInforoom", pageInforoom);
        return "admin/hotel/premanager/roomlist";
    }


}
