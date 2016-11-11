package com.weixin.bean;

/**
 * Created by Liuqi
 * Date: 2016/11/8.
 */
public class Announce {
    private Integer id;
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public Announce(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Announce(String content) {

        this.content = content;
    }

    public Announce() {
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
