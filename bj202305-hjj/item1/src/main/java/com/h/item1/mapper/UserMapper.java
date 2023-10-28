package com.h.item1.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h.item1.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
