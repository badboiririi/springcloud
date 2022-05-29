package com.example.goodsui.controller;

import com.example.goodscommons.pojo.Book;
import com.example.goodscommons.vo.ResultVo;
import com.example.goodsui.service.GoodsUIService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/ui")
public class  GoodsUIController {
    @Resource
    private GoodsUIService goodsUIService;


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        goodsUIService.testGoodsProvider();
        return "success";
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<Book> list(){
        List<Book> bookList=goodsUIService.getBookList();
        return bookList;
    }

    @RequestMapping("/detail/{id}")
    public ResultVo detail(@PathVariable("id")Integer id){
        ResultVo book=goodsUIService.getBookDetail(id);
        return book;
    }

    @PostMapping("/add")
    public String add(@RequestBody Book book){
        goodsUIService.addBook(book);
        return "success";
    }

//    @GetMapping("/getBookByName")
//    public List<Book> getBookByName(@RequestParam("name")String name){
//        return null;
//    }
}
