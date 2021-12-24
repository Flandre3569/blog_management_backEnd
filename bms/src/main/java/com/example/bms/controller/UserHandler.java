package com.example.bms.controller;


import com.example.bms.aop.LogAnnotation;
import com.example.bms.entity.User;
import com.example.bms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserMapper userMapper;

    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
    @GetMapping("/selectAll")
    @LogAnnotation(module="用户",operator="获取所有用户")
    public List<User> findAll() {
        return userMapper.findAllUser();
    }

    @GetMapping("/countUser")
    public Integer countUser() {
        return userMapper.countUser();
    }

    @PostMapping("/upload")
    public Map<String, Object> fileupload(@RequestBody MultipartFile file, HttpServletRequest req) {
        System.out.println(file);
        Map<String, Object> result = new HashMap<>();
        String originName  = file.getOriginalFilename();
        if(!originName.endsWith(".pdf")) {
            result.put("status","error");
            result.put("msg","文件类型错误");
            return result;
        }
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/") + format;
        File folder = new File(realPath);
        if(!folder.exists()) {
            folder.mkdirs();
        }
        String newName = UUID.randomUUID().toString() + ".pdf";
        try {
            file.transferTo(new File(folder,newName));
            result.put("status","success");
            String url = req.getScheme()+ "://" + req.getServerName() + ":" + req.getServerPort() + format + newName;
            result.put("url",url);
        } catch (IOException e) {
            result.put("status","error");
            result.put("msg",e.getMessage());
        }
        return result;
    }
}
