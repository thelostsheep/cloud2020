package com.shlock.springcloud.entities;/*
    @author Shlock
    @create date 2020-07-10 13:16    
*/

import lombok.*;

import java.io.Serializable;


//使用lombok
//自动创建属性的get/set方法
@Data
//创建全部参数的构造器
@AllArgsConstructor
//创建无参构造器
@NoArgsConstructor
//@ToString   创建toString方法
//@EqualsAndHashCode   创建Equals和HashCode方法
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
