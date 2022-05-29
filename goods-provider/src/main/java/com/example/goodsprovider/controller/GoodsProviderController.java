package com.example.goodsprovider.controller;

import com.example.goodscommons.pojo.Book;
import com.example.goodsprovider.service.GoodProviderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class GoodsProviderController {
    @Resource
    private GoodProviderService goodProviderService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("进入了goods-provider");
        return "调用成功";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Book> list(){
        List<Book> bookList = goodProviderService.getBookList();
        return bookList;
    }

    @RequestMapping("/detail/{id}")
    public Book detail(@PathVariable("id")Integer id){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Book book = goodProviderService.getBookDetail(id);
        return book;
    }
    @PostMapping("/add")
    public String add(@RequestBody Book book){
        goodProviderService.addBook(book);
        return "success";
    }

    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
    })
    @RequestMapping("/test_hystrix")
    public String testHystrix(@RequestParam("num")Integer num){
        int n = (int)Math.floor(Math.random()*100);
        int result = n/num;
        return "服务正常返回："+n+"/"+num+"="+result;
    }
    public String fallBack(@RequestParam("num")Integer num){
        return "服务降级反应： num为0";
    }
}
