package com.h.item1.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.h.item1.entity.ContentCategory;
import com.h.item1.mapper.ContentCategoryMapper;
import com.h.item1.service.IContentCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@Service
public class ContentCategoryServiceImpl extends ServiceImpl<ContentCategoryMapper, ContentCategory> implements IContentCategoryService {

}
