package com.h.item1.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.h.item1.entity.Content;
import com.h.item1.entity.vo.InfoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@Mapper
public interface ContentMapper extends BaseMapper<Content> {
//   public List<InfoVo> getList();
}
