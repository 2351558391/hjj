package com.h.item1.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyException extends RuntimeException{
    private String code;
    private String msg;

}
