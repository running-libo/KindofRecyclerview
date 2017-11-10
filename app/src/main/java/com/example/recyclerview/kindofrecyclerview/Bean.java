package com.example.recyclerview.kindofrecyclerview;

import java.io.Serializable;

/**
 * Created by libo on 2017/11/10.
 */

public class Bean implements Serializable{

    private String name;
    private int cover;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }
}