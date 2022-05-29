package com.example.goodsui.service;

import com.example.goodscommons.pojo.Book;
import com.example.goodscommons.vo.ResultVo;

import java.util.List;

public interface GoodsUIService {
    void testGoodsProvider();

    List<Book> getBookList();

    ResultVo getBookDetail(Integer id);

    String addBook(Book book);
}
