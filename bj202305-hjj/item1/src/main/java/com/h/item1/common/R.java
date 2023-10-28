package com.h.item1.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class R {
    private String code;

    private String msg;

    private Map<String,Object> data = new HashMap<>();

    public static R ok(){
        R r = new R();
        r.code = "200";
        return r;
    }

    public static R error(){
        R r = new R();
        r.code = "404";
        return r;
    }

    public R message (String msg){
        this.msg = msg;
        return this;
    }

    public R data (String key,Object value){
        this.data.put(key, value);
        return this;
    }
}
