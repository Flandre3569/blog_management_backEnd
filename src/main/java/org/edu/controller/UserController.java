package org.edu.controller;

import org.edu.dao.UserDao;
import org.edu.po.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/selectAll")
    public String selectAll(Model model) {
        List<Users> list = userDao.selectUsersAll();
        model.addAttribute("usersList",list);
//        System.out.println(list.get(1));
        return "usersList";
    }
}
