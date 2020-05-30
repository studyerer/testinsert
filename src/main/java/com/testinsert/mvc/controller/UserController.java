package com.testinsert.mvc.controller;


import com.testinsert.mvc.entity.User;
import com.testinsert.mvc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
@RequestMapping("")
public class UserController {


    @Resource
    private UserService userService;

    @GetMapping({"/login","login.html"})
    public String login(){
        return "login";
    }

    @GetMapping({"/loginout"})
    public String loginOut(HttpSession session){
//        session.removeAttribute("loginUser");
//        session.removeAttribute("loginUserId");
        session.setAttribute("loginUser",null);
        session.setAttribute("loginUserId",null);
        return "redirect:/login";
    }

    @GetMapping({"/register"})
    public String registerPage(){
        return "register";
    }

    @GetMapping({"/index"})
    public String index(){
        return "index";
    }


    @PostMapping(value = "/login")
    public String checkLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpSession session,
                             Map<String,Object> map){
        User loginUser=userService.selectByName(username);
        if(loginUser==null){
            return "login";
        }
        String shujukuPassWord=loginUser.getPassword();
        if(password.equals(shujukuPassWord)){
            session.setAttribute("loginUser", loginUser.getLoginName());
            session.setAttribute("loginUserId", loginUser.getUserId());
            return "redirect:/index";
        }else{
            map.put("msg","用户名或密码错误");
            return "login";
        }

    }

    @PostMapping({"/register"})
    @ResponseBody
    public String register(@RequestParam("loginName") String loginName,
                           @RequestParam("password") String password,
                           //@RequestParam("erPassword") String erPassword,
                           Map<String ,Object> map){
//        if(password.equals(erPassword)!=true){
//            map.put("msg","密码不一样");
//            return "register";
//        }
        String registerResult =userService.register(loginName,password);

        if(registerResult.equals("true")){
            map.put("msg","注册成功");
            return "redirect:/login";
        }
        else{
            map.put("msg","注册未成功");
            return "register";
        }

    }






}
