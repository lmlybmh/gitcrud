package com.mybatisplus.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;


/**
 * 员工bean
 * @author  lml
 * @date 2021/10/25
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName(value = "Emp")
public class Emp {

    @TableId(value = "eid" ,type = IdType.AUTO)
   private Integer eid ;
   private String ename ;
   private String esex ;
   private String eaddress;

}
