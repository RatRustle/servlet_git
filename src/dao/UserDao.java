package dao;

import pojo.User;

public interface UserDao {
    /**
     * 增删改查
     * @param user
     * @return
     */
    public int regist(User user);

    /**
     * 根据用户名查找用户
     * @param name
     * @return
     */
    public User queryUserByUsername(String name);

    /**
     *
     * 跟据用户名，密码查找用户
     * @param name
     * @param pwd
     * @return
     */
    public User queryUserByUsernamePassword(String name,String pwd);

}
