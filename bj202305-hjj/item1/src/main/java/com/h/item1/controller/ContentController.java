package com.h.item1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.h.item1.common.R;
import com.h.item1.entity.Content;
import com.h.item1.entity.ContentCategory;
import com.h.item1.entity.QueryParam;
import com.h.item1.entity.User;
import com.h.item1.entity.vo.InfoVo;
import com.h.item1.service.IContentCategoryService;
import com.h.item1.service.IContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HJJ
 * @since 2023-10-28
 */
@CrossOrigin
@RestController
@RequestMapping("/content")
public class ContentController {

    @Resource
    private IContentService ics;
    @Resource
    private IContentCategoryService iccs;

    @PostMapping("/list/{current}/{size}")
    public R getQueryContent(@PathVariable Long current,
                             @PathVariable Long size,
                             @RequestBody QueryParam queryParam){
//        System.out.println("current---->"+current+":size---->"+size+": 条件-------->"+queryParam);
        //查询条件
        QueryWrapper<Content> cqw = new QueryWrapper<>();
        if(!queryParam.getName().isEmpty()){cqw.like("name",queryParam.getName());}
        if(!queryParam.getTitle().isEmpty()){cqw.like("title",queryParam.getTitle());}
        if(!(queryParam.getCategoryId()==null)){cqw.eq("category_id",queryParam.getCategoryId());}
        // 分页
        Page<Content> contentPage = new Page<Content>(current, size);
        Page<Content> page = ics.page(contentPage,cqw);
        List<ContentCategory> list = iccs.list(null);

        List<InfoVo> infoVos = new ArrayList<>();
        for (int i= 0 ; i <page.getRecords().size();i++) {
            InfoVo infoVo = new InfoVo();
            BeanUtils.copyProperties(page.getRecords().get(i),infoVo);
            long temp = page.getRecords().get(i).getCategoryId();
            for (ContentCategory cc : list){
                if(temp == cc.getId()){
                    infoVo.setCategoryName(cc.getName());
                }
            }
            infoVos.add(infoVo);
        }
        return R.ok().data("total",page.getTotal()).data("list",infoVos);


    }

    @PostMapping("/aou/")
    public R getQueryContent(@RequestBody Content content){
        //System.out.println("current---->"+current+":size---->"+size+": 条件-------->"+queryParam);
        if(content.getId() == null) {
            boolean save = ics.save(content);
            return save == true ? R.ok().message("添加成功") : R.error().message("添加失败");
        }else{
            return ics.update(content, new QueryWrapper<Content>().eq("id",content.getId())) ?
                    R.ok().message("修改成功") : R.error().message("修改失败");
        }

    }

    @GetMapping("/{id}")
    public R getContent(@PathVariable Long id){
        Content byId = ics.getById(id);
        return R.ok().data("content",byId);
    }

    @DeleteMapping("/{id}")
    public R delContent(@PathVariable Long id){
        return ics.removeById(id) ? R.ok().message("删除成功") : R.error().message("删除失败");
    }

    @GetMapping("/{id}/{status}")
    public R delContent(@PathVariable Long id,@PathVariable String status){
        Content byId = ics.getById(id);
        byId.setStatus(status);
        return ics.update(byId,new QueryWrapper<Content>().eq("id",byId.getId())) ? R.ok().message("修改成功") : R.error().message("修改失败");
    }

}
