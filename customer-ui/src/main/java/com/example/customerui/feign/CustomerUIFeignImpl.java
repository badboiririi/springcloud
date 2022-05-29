package com.example.customerui.feign;

import com.example.goodscommons.pojo.Customer;
import com.example.goodscommons.vo.ResultVo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerUIFeignImpl implements CustomerUIFeign{
    @Override
    public List<Customer> getCustomerList() {
        return null;
    }

    @Override
    public ResultVo getCustomerDetail(Integer id) {
        return ResultVo.error("feign的服务降级响应");
    }
}
