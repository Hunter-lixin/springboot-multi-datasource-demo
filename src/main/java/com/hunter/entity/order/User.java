package com.hunter.entity.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Double money;
}
