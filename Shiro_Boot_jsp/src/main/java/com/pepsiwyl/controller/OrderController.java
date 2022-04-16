package com.pepsiwyl.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author by pepsi-wyl
 * @date 2022-04-12 15:13
 */

@Slf4j

@Controller
@RequestMapping(name = "订单控制器", path = "/order")
public class OrderController {

    // 代码方式授权
    @GetMapping("/save")
    public String SaveOrder() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("order_manager") || subject.hasRole("admin")) {
            log.info("保存成功");
        } else {
            log.info("无权访问");
        }
        return "redirect:/index.jsp";
    }

    // 注解方式授权
    @RequiresRoles(value = {"order_manager", "admin"})  //用来判断角色  同时具有 order_manager admin
    @RequiresPermissions("order:delete:*")              //用来判断权限字符串
    @GetMapping("/delete")
    public String DeleteOrder() {
        log.info("进入方法");
        return "redirect:/index.jsp";
    }

}
