package com.mybatisplus.mapper;

import com.mybatisplus.bean.Dept;
import com.mybatisplus.bean.Emp;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

/**
 * @author lml
 * @date 2021-10-25
 * 部门对应mapper接口
 */
@Mapper
public interface DeptMapper {


    /**
     * 用于关联查询，查询部门表下对应的员工表信息
     * @param did
     * @return  Dept
     */
    Dept selectDeptById(int did);



    /**
     * 查询视图
     * @return View
     */
    @Select("select * from test_view02")
     List<Map<String, Object>> selectView();



    @Select("select * from dept where did=#{did}")
    @Results({

            @Result(id = true,column = "did",property = "did"),
            @Result(column = "dname",property = "dname"),
            @Result(column = "did",property = "emp",
                    many=@Many(select = "com.mybatisplus.mapper.EmpMapper.selectAll02",fetchType= FetchType.EAGER)
            )
    })
    /**
     * 使用关联映射查询对应部门名字下的员工
     * @return list
     * @param dname
     */
    List<Dept> selectNameByDept(int did);
}
