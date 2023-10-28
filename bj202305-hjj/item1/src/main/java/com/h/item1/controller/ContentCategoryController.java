package com.h.item1.controller;

import com.h.item1.common.R;
import com.h.item1.entity.ContentCategory;
import com.h.item1.service.IContentCategoryService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 内容分类 前端控制器
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@CrossOrigin
@RestController
@RequestMapping("/contentCategory")
public class ContentCategoryController {
    @Resource
    private IContentCategoryService ics;

    @GetMapping("/list")
    public R getAllCategorys(){
        List<ContentCategory> list = ics.list(null);
        return R.ok().data("list",list);
     }
}
