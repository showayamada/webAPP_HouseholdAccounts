package com.example.webapp_householdaccounts.service;

import java.util.Date;
import java.util.List;

import com.example.webapp_householdaccounts.api.RecognitionAPI;
import com.example.webapp_householdaccounts.dto.ExpenseRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.webapp_householdaccounts.entity.Expense;
import com.example.webapp_householdaccounts.repository.ExpenseRepository;

/**
 * 支出情報サービス
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ExpenseService {

    private RecognitionAPI api;
    private JdbcTemplate jdbcTemplate;

    public ExpenseService(RecognitionAPI api, JdbcTemplate jdbcTemplate) {
        this.api = api;
        this.jdbcTemplate = jdbcTemplate;
    }

    // 支出情報リポジトリ
    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * 支出情報　全検索
     * @return 検索結果
     */
    // データベースから支出情報をすべて取得する
    public List<Expense> searchAll() {
        return expenseRepository.findAll();
    }

    /**
     * 支出情報　新規登録
     * manual register
     */
    // データベースに画面からの入力データを登録する
//    public void create (ExpenseRequest expenseRequest) {
//        Date now = new Date();
//        Expense expense = new Expense();
//        expense.setName(expenseRequest.getName());
//        expense.setPrice(expenseRequest.getPrice());
//        expense.setCategory(expenseRequest.getCategory());
//        //expense.setRegistered(expenseRequest.getRegistered());
//        expense.setCreateDate(now);
//        expense.setUpdateDate(now);
//        expenseRepository.save(expense);
//    }



    // 画像で登録
    public int insert(Resource resource) {
        RecognitionResponse response = api.Recognition(resource);
        int price = response.getPrice();
        Date now = new Date();
        String sql = "insert into expense VALUES(?,?,?,?,?,?,?,?,?)";
        int n = jdbcTemplate.update(sql, 1,"test",price,"test","test",now,now,null, false);
        return n;
    }

    /**
     * 支出情報　主キー検索
     * @return 検索結果
     */
    public Expense findById (Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

}
