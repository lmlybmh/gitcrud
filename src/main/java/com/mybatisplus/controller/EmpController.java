package com.mybatisplus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.bean.Dept;
import com.mybatisplus.bean.Emp;
import com.mybatisplus.mapper.DeptMapper;
import com.mybatisplus.mapper.EmpMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Emp控制类
 * @author lml
 * @date 2021-10-25
 *
 */
@RestController
@RequestMapping("/emp")
@Api(tags = "Emp")
public class EmpController {

    @Autowired
    private EmpMapper empMapper;


    @ApiOperation(value = "插入一个员工")
    @PutMapping("/put")
    public String insertOneEmp(@ApiParam("一个员工") Emp emp){
        int flag= empMapper.insert(emp);
        return  flag>0?"成功":"失败";
    }


    @ApiOperation(value = "删除一个员工")
    @DeleteMapping("/delete")
    public String deleteOneEmp(int eid){
        int flag= empMapper.deleteById(eid);
        return flag>0?"成功":"失败";
    }

    @ApiOperation(value = "查找一个员工")
    @GetMapping("/get")
    public Emp selectAllEmp(int eid){
        Emp emp=new Emp();
        emp= empMapper.selectById(eid);
        return emp;
    }

    @ApiOperation(value = "修改一个员工信息")
    @PostMapping("/update")
    public String updateOneEmp(Emp emp){
        int flag= empMapper.updateById(emp);
        return flag>0?"成功":"失败";
    }

    @ApiOperation(value = "根据名字模糊查询")
    @GetMapping("/getlikename")
    public List<Emp> getAllEmpsLikeName(String lname){
        List <Emp> list= empMapper.selectEmpslikeName("%"+lname+"%");
        return list;
    }

    @ApiOperation(value = "查询前n条记录")
    @GetMapping("/getTop")
    public List<Emp> getTopEmp(int num){
        List <Emp> list= empMapper.selectTop(num);

        return list;
    }


    @ApiOperation(value = "分页查询相关员工")
    @GetMapping("/getPage")
    public List<Emp> getPage(Integer current,Integer size){
        Page<Emp> page=new Page<>(current,size);
        empMapper.selectPage(page,null);
        List<Emp> list= page.getRecords();

        return list;
    }


    @ApiOperation(value = "查询的存储过程")
    @GetMapping("/procedureSelect")
    public List<Emp> procedureSelect(){
        List<Emp> list =empMapper.selectProcedure();
        return list;
    }

    @ApiOperation(value = "插入的存储过程")
    @PutMapping("/procedureInsert")
    public void procedureInsert(String ename,String esex,String eaddress,int did){
         empMapper.insertProcedure( ename, esex, eaddress, did);
    }


}
