package com.h.item1.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.item1.entity.User;
import com.h.item1.mapper.UserMapper;
import com.h.item1.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User getOneById(Long id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public Boolean addUser(User user) {
        int insert = userMapper.insert(user);
        return insert > 0 ? true :false;
    }

    @Override
    public Boolean updateUser(User user) {
        int update = userMapper.updateById(user);
        return update > 0 ? true :false;
    }

    @Override
    public User getOneByName(String Name) {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, Name));
        return user;
    }

}
