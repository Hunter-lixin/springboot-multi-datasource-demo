package com.hunter.entity.cust;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Money {
    private Integer id;
    private Integer basic;
    private Integer reward;
    private Integer punishment;
}
