package com.blog.support;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by hulixiong on 2016/11/5.
 */
@Data
public class PageDto<T> implements Serializable {
    private static final long serialVersionUID = 8656597559014685635L;
    private long count;        //总记录数
    private List<T> data;    //结果集
    private int page;    // 当前页
    private int size;        //每页数量

    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param list          page结果
     */

    public PageDto(List<T> list) {
        if (list instanceof Page) {
            Page<T> page = (Page<T>) list;
            this.page = page.getPageNum();
            this.size = page.getPageSize();
            this.count = page.getTotal();
            this.data = page;
        }
    }
}
