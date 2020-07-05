package com.southwind.mybatisplus.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;

//通过实现接口的方式实现枚举
public enum AgeEnum implements IEnum<Integer> {
    ONE(20,"20岁"),
    TWO(21,"21岁"),
    THREE(23,"23岁");

    AgeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;

    @Override
    public Integer getValue() {
        return this.code;
    }
}
