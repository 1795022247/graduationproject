package com.jesper.controller;

import com.github.pagehelper.PageInfo;
import com.jesper.model.Admin;
import com.jesper.model.CliOrder;
import com.jesper.model.ClientUser;
import com.jesper.service.CliOrderService;
import com.jesper.service.ClientUserService;
import com.jesper.service.RoomService;
import com.jesper.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClientUserController {


    @Autowired
    private RoomService roomService;

    @Autowired
    private CliOrderService cliOrderService;

    @Autowired
    private ClientUserService clientUserService;

    /*
    映射到登陆的界面
     */
    @RequestMapping(value = "/user/tologin", method = RequestMethod.GET)
    public String tologin() {
        return "login";
    }


    /*
    来到展示的主页
    index.html
     */
    @RequestMapping(value = "/user/toindex", method = RequestMethod.GET)
    public String toindex() {
        return "index";
    }
/*
转到用户注册页面
 */

    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register() {
        return "register";
    }



/*
用户退出 映射到 主页 index.html
 */

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {


        request.getSession().invalidate();


        return "index";
    }

    /*

    执行=登陆操作
    参数clientUser 对象Clientuser
    如果：
    登陆成功则来到酒店的主页

    失败：


     */
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)

    public String login(ClientUser clientUser, Model model, HttpServletRequest request, HttpSession session) {

        ClientUser clientUser1 = clientUserService.ToLoginfindByUser(clientUser);


        if (clientUser1 != null) {

            request.getSession().setAttribute("clientUser", clientUser1);
            session.setAttribute("clientUser", clientUser1);
            Map<String, Object> map = new HashMap<>();

            return "redirect:/user/hotellist";

        } else {


            Map<String, Object> map = new HashMap<>();
            map.put("url", "/user/tologin");
            request.setAttribute("errorInfo", "用户名或密码错误！");
            return "login";

        }


    }

    /*
  插入信息
    参数 clientUser  对象
     */
    @RequestMapping(value = "/user/insert", method = RequestMethod.POST)
    @ResponseBody
    public String insertUser(ClientUser clientUser, Model model, HttpServletRequest request) {


        System.out.println(clientUser);

        //执行插入操作
        clientUserService.insertSelective(clientUser);


        return "200";
    }

    /*
    用户修改密码
    参数：ClientUser cleintUser
     */
    @RequestMapping(value = "/user/upmyInfo", method = RequestMethod.POST)

    public String updateInfo(ClientUser clientUser, Model model, HttpServletRequest request) {

        clientUserService.updateByPrimaryKeySelective(clientUser);

        return "redirect:/user/myInfo";
    }

    /*
    删除用户
    返回值json 格式 200 成功
    参数： Interger clientuser.id
     */
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse updateInfo(Integer id, HttpServletRequest request) {

        clientUserService.deleteByPrimaryKey(id);

        return RestResponse.success();
    }








    /*
   个人信息
   参数：id
    */

    @RequestMapping("/user/myInfo")
    public String myInfo(Model model, HttpServletRequest request) {

        ClientUser clientUser = (ClientUser) request.getSession().getAttribute("clientUser");

        ClientUser clientUser1 = clientUserService.selectByPrimaryKey(clientUser.getId());


        model.addAttribute("clientUser", clientUser1);


        return "hotel/member/myInfo";
    }

    /*
    完成添加的界面
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public RestResponse addUser(ClientUser clientUser, HttpServletRequest request) {

        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Integer integer=((Admin) request.getSession().getAttribute("admin")).getId();
        clientUser.setFlag1(admin.getHotolId() + "");
        try {

            clientUserService.insertSelective(clientUser);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return RestResponse.success();
    }
/*
添加客户界面
 */

    @RequestMapping("/toaddUser")
    public String toaddRoom(Model model) {
        return "admin/hotel/premanager/addUser";
    }


    /*
个人账单查询
参数：id
*/
    @RequestMapping("/user/myReserve")
    public String myReserve(@RequestParam(value = "page", defaultValue = "1") Integer page,
                            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                            ServletRequest requests, Model model, HttpServletRequest request) {
        ClientUser clientUser = (ClientUser) request.getSession().getAttribute("clientUser");
        System.out.println(clientUser);
    try{

        PageInfo<CliOrder> cliOrderPageInfo = cliOrderService.findByCliId(clientUser.getId(), page, limit);


        model.addAttribute("cliList", cliOrderPageInfo);


        return "hotel/member/myReserve";
    }catch (Exception e){
        e.printStackTrace();
        return "hotel/member/myReserve";
    }

    }

    @RequestMapping("/backuserlist")
    public String backuserlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "limit", defaultValue = "3") Integer limit,
                               ServletRequest requests, Model model, HttpServletRequest request) {


        Admin admin = (Admin) request.getSession().getAttribute("admin");


        List<CliOrder> cliOrderList = cliOrderService.findByAdmin(admin.getHotolId());

        PageInfo<ClientUser> clientUserPageInfo = clientUserService.findBy(cliOrderList, admin.getHotolId());


        System.out.println(clientUserPageInfo);


        model.addAttribute("cliList", clientUserPageInfo);


        return "admin/hotel/premanager/vipmanager";
    }

    /*
    客户信息管理模块
     */
    @RequestMapping("/finduserlist")
    public String backuserlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(value = "limit", defaultValue = "3") Integer limit,
                               ClientUser clientUser, ServletRequest requests, Model model, HttpServletRequest request) {

        Admin admin = (Admin) request.getSession().getAttribute("admin");

        List<CliOrder> cliOrderList = cliOrderService.findByAdmin(admin.getHotolId());

        PageInfo<ClientUser> clientUserPageInfo = clientUserService.findByUserList(clientUser, admin, page, limit);

        System.out.println(clientUserPageInfo);

        model.addAttribute("cliList", clientUserPageInfo);

        return "admin/hotel/premanager/vipmanager";
    }


    @RequestMapping("/user/hotellist")
    public String hotellist(Model model, HttpServletRequest request) {


        Map<String, Object> map = roomService.selectByList();


        model.addAttribute("map", map);


        return "hotolList";
    }

}
