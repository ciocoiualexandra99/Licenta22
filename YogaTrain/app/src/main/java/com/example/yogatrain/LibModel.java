package com.example.yogatrain;

public class LibModel {

    String title,desc;
    int photo;

    public LibModel(String title, String desc, int photo) {
        this.title = title;
        this.desc = desc;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
