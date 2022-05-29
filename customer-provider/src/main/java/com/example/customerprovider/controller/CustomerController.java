package com.example.customerprovider.controller;

import com.example.customerprovider.dao.CustomerDao;
import com.example.goodscommons.pojo.Customer;
import com.example.goodscommons.vo.ResultVo;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerDao customerDao;
    @RequestMapping("/list")
    public List<Customer> list(){
        return customerDao.getCustomerList();
    }
    @RequestMapping("/detail")
    public ResultVo detail(@RequestParam("id")Integer id){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Customer customer = customerDao.getCustomerById(id);
        return ResultVo.ok(customer);
    }
}
