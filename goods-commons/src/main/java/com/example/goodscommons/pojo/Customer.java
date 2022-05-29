package com.example.goodscommons.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "顾客对象",description = "顾客对象的属性")
public class Customer {
    @ApiModelProperty(value = "顾客id",dataType = "int",required = true,example = "0")
    private Integer customerId;
    private String customerName;
    private String customerAddress;
    private Integer customerTicket;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getCustomerTicket() {
        return customerTicket;
    }

    public void setCustomerTicket(Integer customerTicket) {
        this.customerTicket = customerTicket;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerTicket=" + customerTicket +
                '}';
    }
}
