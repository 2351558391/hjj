package com.h.item1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.h.item1.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
public interface IUserService extends IService<User> {
    public User getOneById(Long id);
    public Boolean addUser(User user);
    public Boolean updateUser(User user);
    public User getOneByName(String Name);
}
