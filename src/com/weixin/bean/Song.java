package com.weixin.bean;

/**
 * Created by Liuqi
 * Date: 2016/11/5.
 */
public class Song {
    private Integer id;
    private Integer niming;
    private Integer status;
    private String song;
    private String singer;
    private String diangeren;
    private String receiver;
    private String jiyu;
    private String time;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNiming() {
        return niming;
    }

    public void setNiming(Integer niming) {
        this.niming = niming;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getDiangeren() {
        return diangeren;
    }

    public void setDiangeren(String diangeren) {
        this.diangeren = diangeren;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getJiyu() {
        return jiyu;
    }

    public void setJiyu(String jiyu) {
        this.jiyu = jiyu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Song() {
    }

    public Song(Integer niming, String song, String singer, String diangeren, String receiver, String jiyu) {
        this.niming = niming;
        this.song = song;
        this.singer = singer;
        this.diangeren = diangeren;
        this.receiver = receiver;
        this.jiyu = jiyu;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", song='" + song + '\'' +
                ", singer='" + singer + '\'' +
                ", diangeren='" + diangeren + '\'' +
                ", receiver='" + receiver + '\'' +
                ", jiyu='" + jiyu + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song1 = (Song) o;
        if (!getId().equals(song1.getId())) return false;
        return getSong() != null ? getSong().equals(song1.getSong()) : song1.getSong() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getSong() != null ? getSong().hashCode() : 0);
        return result;
    }
}
