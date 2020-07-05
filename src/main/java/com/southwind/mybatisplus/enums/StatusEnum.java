package com.southwind.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

    //通过枚举类注解“@EnumValue”实现枚举

public enum StatusEnum {
    WORK(1,"上班"),
    REST(0,"休息 ");


//构造函数
    StatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @EnumValue
    private Integer code;   //code和表中字段值对应
    private String msg;


}
