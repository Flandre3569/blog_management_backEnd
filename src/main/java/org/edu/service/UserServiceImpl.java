package org.edu.service;

import org.edu.dao.UserDao;
import org.edu.po.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    @Override
    public List<Users> selectUsersAll() {
        return userDao.selectUsersAll();
    }
}
