package com.example.goodsprovider.service;

import com.example.goodscommons.pojo.Book;
import com.example.goodsprovider.dao.GoodsDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsProviderServiceImpl implements GoodProviderService{
    @Resource
    private GoodsDao goodsDao;

    @Override
    public List<Book> getBookList() {
        return goodsDao.getBookList();
    }

    @Override
    public Book getBookDetail(Integer id) {
        return goodsDao.getBookDetail(id);
    }

    @Override
    public void addBook(Book book) {
        goodsDao.addBook(book);
    }
}
