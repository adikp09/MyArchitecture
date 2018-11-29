package com.dev.adi.myarchitecture.retrofit;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("name")
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
