package service;

import pojo.User;

public interface UserService {
    /**
     * 注册业务
     * @param user
     * @return
     */
    public int regist(User user);

    /**
     * 登录业务
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 根据用户名查询用户是否存在
     * @param username
     * @return
     */
    public Boolean existUsername(String username);
}
