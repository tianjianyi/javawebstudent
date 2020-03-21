package com.yifeng.domain;

public class QueryVo {
    //当前页
    private Integer page;
    //每页数
    private Integer size = 10;

    private Integer startRow = 0;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getStartRow() {
        return startRow;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "page=" + page +
                ", size=" + size +
                ", startRow=" + startRow +
                '}';
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }
}
