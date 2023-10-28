package com.h.item1;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h.item1.entity.Content;
import com.h.item1.entity.vo.InfoVo;
import com.h.item1.mapper.ContentMapper;
import com.h.item1.service.IContentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class Item1ApplicationTests {

    @Resource
    private IContentService ics;
    @Test
    void contextLoads() {
        Page<Content> contentPage = new Page<>(1, 10);
        Page<Content> page = ics.page(contentPage);
        InfoVo infoVo = new InfoVo();
        BeanUtils.copyProperties(page.getRecords().get(1),infoVo);
        System.out.println(infoVo);
    }



}
