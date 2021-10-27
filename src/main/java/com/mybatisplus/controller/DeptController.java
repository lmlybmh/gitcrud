package com.mybatisplus.controller;



import com.mybatisplus.bean.Dept;
import com.mybatisplus.mapper.DeptMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Emp控制类
 * @author lml
 * @date 2021-10-25
 *
 */
@RestController
@RequestMapping("/dept")
@Api(tags = "Dept")
public class DeptController {

    @Autowired
    private DeptMapper deptMapper;


    @ApiOperation(value="xml查询对应部门下的所有员工")
    @GetMapping("/getDept")
    public Dept getDept(int did){
        Dept dept=new Dept();
        dept=deptMapper.selectDeptById(did);

        return dept;
    }


    @ApiOperation(value="查询视图")
    @GetMapping("/getview")
    public  List<Map<String, Object>> getView(){

        List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();
        list=deptMapper.selectView();

        return list;
    }

    @ApiOperation(value="注解查询对应部门下的所有员工")
    @GetMapping("/getEmpBelongDept")
    public List<Dept> getEmpBelongDept(int did) throws Exception {

        List<Dept>list=new ArrayList<>();
        list=deptMapper.selectNameByDept(did);
        return list;

    }


}
