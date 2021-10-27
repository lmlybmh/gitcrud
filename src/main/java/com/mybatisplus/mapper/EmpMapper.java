package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.bean.Emp;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lml
 * @date 2021-10-25
 * 员工对应的接口
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    /**
     * 根据名字模糊查询一个人信息
     * @param lname
     * @return Emp对象
     */
    @Select("select * from emp where ename like #{lname} ")
    List<Emp> selectEmpslikeName(String lname);


    /**
     * 查询前几条记录
     * @param num
     * @return Emp对象
     */
    List<Emp> selectTop(int num);

    /**
     * 查询所有员工信息
     * 用于一对多映射，使用xml实现
     * @return Emp对象
     *
     */
    List<Emp> selectAll();


    /**
     * 查询所有员工信息
     * 用于一对多映射，使用注解实现
     * @return Emp对象
     *
     */
    @Results({
            @Result(id = true,column = "eid",property = "eid"),
            @Result(column = "ename",property = "ename"),
            @Result(column = "esex",property = "esex"),
            @Result(column = "eaddress",property = "eaddress")

    })
    @Select("select * from emp where did=#{did}")
    List<Emp> selectAll02();

    /**
     * 使用存储过程查看
     * @return Emp
     */
    @Select("call select_allemp")
    List<Emp>selectProcedure();


    /**
     * 使用存储过程插入一条信息
     */
    @Select("call test_procedure02(#{ename,mode=IN},#{esex,mode=IN},#{eaddress,mode=IN},#{did,mode=IN}) ")
     void insertProcedure(String ename,String esex,String eaddress,int did);


}
