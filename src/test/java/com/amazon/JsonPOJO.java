package com.amazon;

import com.amazon.Utils.JsonToObject;

public class JsonPOJO {


    String username;
    String password;

    public JsonPOJO(String username,String password){
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
