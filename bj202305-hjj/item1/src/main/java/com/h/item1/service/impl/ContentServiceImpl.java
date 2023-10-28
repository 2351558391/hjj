package com.h.item1.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.item1.entity.Content;
import com.h.item1.mapper.ContentMapper;
import com.h.item1.service.IContentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

}
