package com.h.item1.entity.vo;


import com.h.item1.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoVo{
    private Long id;

    /**
     * 内容类目ID
     */
    private Long categoryId;

    /**
     * 名字
     */
    private String name;

    /**
     * 内容标题
     */
    private String title;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片绝对路径
     */
    private String pic;

    /**
     * 状态
     */
    private String status;

    /**
     * 排序
     */
    private Integer sortOrder;
    private String categoryName;

}
