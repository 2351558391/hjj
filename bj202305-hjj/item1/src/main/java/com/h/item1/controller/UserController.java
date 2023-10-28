package com.h.item1.controller;

import com.h.item1.common.MyException;
import com.h.item1.common.R;
import com.h.item1.entity.User;
import com.h.item1.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

     @Resource
     private IUserService ls;
     @GetMapping("/list")
     public R getAll(){
          List<User> list = ls.list(null);
          return R.ok().data("list",list);
     }

     @PostMapping("/login")
     public R loginInfo(@RequestBody User login){
          System.out.println(login);
          User user = ls.getOneByName(login.getUsername());
          if(user == null){
               throw new MyException("404","账号不存在，请前往注册");
          }
          if (!user.getPassword().equals(login.getPassword())){
               throw new MyException("404","/密码不正确");}
          return new R().ok().message("登录成功").data(login.getUsername(),user).data("token",login.getUsername());
     }

     @GetMapping("/info")
     public R getInfo(String token) {
          User user = ls.getOneByName(token);
          System.out.println("====================================>" +user+"<======================================");
          if (user == null) {
               return new R().ok().data("roles", "[admin]")
                       .data("name", "admin")
                       .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
          } else {
               return new R().ok().data("roles", "[admin]")
                       .data("name", user.getUsername())
                       .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif").data("userId",user.getId()).message("登录成功");
          }
     }

     @GetMapping("/logout")
     public R logout() {
          return R.ok().message("登出成功");
     }
}
