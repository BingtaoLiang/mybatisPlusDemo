package com.southwind.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.southwind.mybatisplus.enums.AgeEnum;
import com.southwind.mybatisplus.enums.StatusEnum;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "user")      //当实体类名称和表名不一致时，映射数据库表名
public class User {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")         //TableFiled将非主键字段名与实体类属性映射起来,value为表中字段名
    private String username;

    private Integer age;
//    private AgeEnum age;        //通过实现接口的方式，实现枚举

    @TableField(fill = FieldFill.INSERT)    //创建时自动赋值
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)    //创建和修改时自动赋值
    private Date updateTime;

    @Version        //标记乐观锁，保证并发环境下数据的安全性
    private Integer version;

    private StatusEnum status;  //成员变量的名称要和表中字段名对应

//    @TableLogic
    private Integer deleted;       //逻辑删除，并不是真的将数据从数据库中删除，而是改变该字段的值来实现

}
