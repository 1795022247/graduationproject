package com.jesper.controller;

import com.github.pagehelper.PageInfo;
import com.jesper.model.Admin;
import com.jesper.model.CliOrder;
import com.jesper.model.ClientUser;
import com.jesper.model.Room;
import com.jesper.service.CliOrderService;
import com.jesper.service.ClientUserService;
import com.jesper.service.RoomService;
import com.jesper.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

@Controller
public class CliOrderController {


    @Autowired
    private RoomService roomService;
    @Autowired
    private CliOrderService cliOrderService;

    @Autowired

    private ClientUserService clientUserService;

    /*
    酒店预定的操作
    参数 是房间的id
     */
    @RequestMapping("/toAddOrder/{id}")
    public String toAddOrder(@PathVariable Integer id, HttpServletRequest request, Model model) {


        System.out.println(id);
        Room room = roomService.selectByPrimaryKey(id);

        model.addAttribute("room", room);
//      CliOrder cliOrder=new CliOrder();
//
//      cliOrder.setRoomId(room.getId());
//
//      cliOrder.setCateateDate(new Date());
//
//      cliOrder.setClientId(clientUser.getId());


        return "hotel/orderAdd";

    }

/*
增加订单
参数 CliOrder cliorder

 */

    @RequestMapping("/AddOrder")
    @ResponseBody
    public String AddOrder(CliOrder cliOrder, HttpServletRequest request, Model model) {

        ClientUser clientUser = (ClientUser) request.getSession().getAttribute("clientUser");


        System.out.println(clientUser);
        if (clientUser != null) {

            ClientUser clientUser1 = clientUserService.selectByPrimaryKey(clientUser.getId());
            Room room = roomService.selectByPrimaryKey(cliOrder.getRoomId());
            cliOrder.setTotalprice(room.getPrice() * cliOrder.getCount());

            cliOrder.setCateateDate(new Date());


            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());//设置起时间
            //System.out.println("111111111::::"+cal.getTime());
            cal.add(Calendar.DATE, cliOrder.getCount());//增加一年

            System.out.println("输出::" + cal.getTime());

            cliOrder.setClientId(clientUser1.getId());
            //  cliOrder.setCateateDate(cliOrder.getCateateDate());

            cliOrder.setEndDate(cal.getTime());


            cliOrderService.insertSelective(cliOrder);

            return "200";
        } else {
            return "403";
        }


    }
/*
对订单的结账
 */

    @RequestMapping("/accounts")
    @ResponseBody
    public RestResponse accounts(Model model, Integer id) {

        try {
            CliOrder cliOrder = cliOrderService.selectByPrimaryKey(id);
            cliOrder.setSign(1);
            cliOrderService.updateByPrimaryKey(cliOrder);
            return RestResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.failure("修改失败");
    }
/*
追交押金的操作
 */

    @RequestMapping("/Recover_deposit")
    @ResponseBody
    public RestResponse Recover_deposit(Model model, Integer id, Integer val) {

        try {

            CliOrder cliOrder = cliOrderService.selectByPrimaryKey(id);
            if (cliOrder.getSign() != 1) {
                Integer s = cliOrder.getDeposi();
                cliOrder.setDeposi(s + val);
                cliOrderService.updateByPrimaryKey(cliOrder);
                return RestResponse.success();
            }
//            } else if (cliOrder.getSign() == 2) {
//                return RestResponse.failure("此订单已经进行了入住，无需再次追缴押金");
//            }
            else {
                return RestResponse.failure("此订单已结账");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.failure("修改失败");
    }

    /*
    订单的入住
    参数订单的id
     */
    @RequestMapping("/ruzhu")
    @ResponseBody
    public RestResponse ruzhu(Model model, Integer id, Integer val) {

        try {

            CliOrder cliOrder = cliOrderService.selectByPrimaryKey(id);
            if (cliOrder.getSign() != 1) {
                cliOrder.setSign(2);
                cliOrderService.updateByPrimaryKey(cliOrder);
                return RestResponse.success();
//            } else if (cliOrder.getSign() == 2) {
//                return RestResponse.failure("此订单已经进行了入住，无需再次入住");
//            }
            } else {
                return RestResponse.failure("此订单已结账");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.failure("修改失败");
    }


    /*
    客户订单的退订
    参数 顶单的id
     */
    @RequestMapping("/unsubscribe")
    @ResponseBody
    public RestResponse unsubscribe(Model model, Integer id, String val) {

        try {
            CliOrder cliOrder = cliOrderService.selectByPrimaryKey(id);
            System.out.println(cliOrder);
            if (cliOrder.getSign() == 0) {
                cliOrder.setSign(2);
                cliOrderService.updateByPrimaryKey(cliOrder);
                return RestResponse.success();
            } else {
                return RestResponse.failure("此订单已结账");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.failure("退订失败");
    }


    /*
    酒店订单列表
    参数酒店的id
    */
    @RequestMapping("/backorderlists")
    public String backorderlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                ServletRequest requests, Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        int sign = 0;
        try {

            PageInfo<CliOrder> cliOrderPageInfo = cliOrderService.findByAdminHotolId_sign(admin.getHotolId(), page, limit, sign);

            try {
                model.addAttribute("cliList", cliOrderPageInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }


            return "admin/hotel/premanager/preHotel";
        } catch (Exception e) {
            e.printStackTrace();
            return "admin/hotel/premanager/preHotel";
        }

    }

    @RequestMapping("/findByorder2")
    public String findByorder2(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "limit", defaultValue = "20") Integer limit,
                              CliOrder cliOrder, ServletRequest requests, Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        int sign = 2;

        try {
            PageInfo<CliOrder> cliOrderPageInfo = cliOrderService.findByAdminHotolLikeRoomId(admin.getHotolId(), page, limit, sign, cliOrder);
            model.addAttribute("cliList", cliOrderPageInfo);
            return "admin/hotel/premanager/preHotel2";
        } catch (Exception e) {

            e.printStackTrace();
            return "admin/hotel/premanager/preHotel2";
        }


    }
    @RequestMapping("/findByorder1")
    public String findByorder1(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "limit", defaultValue = "20") Integer limit,
                              CliOrder cliOrder, ServletRequest requests, Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        int sign = 1;

        try {
            PageInfo<CliOrder> cliOrderPageInfo = cliOrderService.findByAdminHotolLikeRoomId(admin.getHotolId(), page, limit, sign, cliOrder);
            model.addAttribute("cliList", cliOrderPageInfo);
            return "admin/hotel/premanager/preHotel1";
        } catch (Exception e) {

            e.printStackTrace();
            return "admin/hotel/premanager/preHotel1";
        }


    }

    @RequestMapping("/findByorder")
    public String findByorder(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "limit", defaultValue = "20") Integer limit,
                              CliOrder cliOrder, ServletRequest requests, Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        int sign = 0;

        try {
            PageInfo<CliOrder> cliOrderPageInfo = cliOrderService.findByAdminHotolLikeRoomId(admin.getHotolId(), page, limit, sign, cliOrder);
            model.addAttribute("cliList", cliOrderPageInfo);
            return "admin/hotel/premanager/preHotel";
        } catch (Exception e) {

            e.printStackTrace();
            return "admin/hotel/premanager/preHotel";
        }


    }

    /*
    查询已入住的账单
     */
    @RequestMapping("/backorderruzhu")
    public String backorderruzhu(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 ServletRequest requests, Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        int sign = 2;
        PageInfo<CliOrder> cliOrderPageInfo = cliOrderService.findByAdminHotolId_sign(admin.getHotolId(), page, limit, sign);


        model.addAttribute("cliList", cliOrderPageInfo);


        return "admin/hotel/premanager/preHotel2";
    }


    @RequestMapping("/backorderstatus")
    public String backorderstatus(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                  ServletRequest requests, Model model, HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");

        int sign = 1;
        PageInfo<CliOrder> cliOrderPageInfo = cliOrderService.findByAdminHotolId_sign(admin.getHotolId(), page, limit, sign);


        model.addAttribute("cliList", cliOrderPageInfo);


        return "admin/hotel/premanager/preHotel1";
    }


}
