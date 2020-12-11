package com.example.wastesortingapp;

import java.util.ArrayList;

public interface OnDatabaseCallback {
    public void insert(String num, String title, String contents);
    public ArrayList<BarInfo> selectAll();
}
