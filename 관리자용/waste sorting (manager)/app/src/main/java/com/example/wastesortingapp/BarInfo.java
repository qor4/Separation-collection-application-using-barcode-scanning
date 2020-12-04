package com.example.wastesortingapp;

public class BarInfo {

    String num;
    String title;
    String contents;

    public BarInfo(String name, String title, String contents) {
        this.num = num;
        this.title = title;
        this.contents = contents;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return "BarInfo{" +
                "num='" + num + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }

}
