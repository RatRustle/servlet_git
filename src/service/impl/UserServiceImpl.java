package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public int regist(User user) {
        if (user.getUsername()==null||user.getUsername()==""){
            return 0;
        }else if (user.getPassword()==null||user.getPassword()==""){
            return 0;
        } else if (user.getPhone()==null||user.getPhone()=="") {
            return 0;
        }
        return userDao.regist(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernamePassword(user.getUsername(),user.getPassword());
    }

    @Override
    public Boolean existUsername(String username) {
        if (userDao.queryUserByUsername(username)==null){
            //等于null，说明可用
            return false;
        }else {
            return true;
        }

    }
}
