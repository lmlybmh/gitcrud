package com.mybatisplus.bean;

import lombok.*;

import java.util.List;

/**
 * @author lml
 * @date 2021-10-25
 * 员工bean
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dept {
    private Integer did ;
    private String  dname ;
    private List<Emp> emp;

}
