package com.atguigu.mybatisplus.pojo;

import com.atguigu.mybatisplus.enums.SexEnum;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//设置实体类所对应的数据库表名
//@TableName("user")
public class User {
    //将属性对应的字段指定为主键
    //@TableId注解的value属性用于指定主键的字段
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //指定属性所对应的字段名
    @TableField("name")
    private String name;

    private Integer age;

    private String email;

    //逻辑删除
    @TableLogic
    private Integer isDeleted;

    private SexEnum sex;
}
