package org.edu.dao;

import org.edu.po.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    public List<Users> selectUsersAll();
}
