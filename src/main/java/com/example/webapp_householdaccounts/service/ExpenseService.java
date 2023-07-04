package com.example.webapp_householdaccounts.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.webapp_householdaccounts.entity.Expense;
import com.example.webapp_householdaccounts.repository.ExpenseRepository;

/**
 * 支出情報サービス
 */
@Service
public class ExpenseService {

    // 支出情報リポジトリ
    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * 支出情報　全検索
     * @return 検索結果
     */
    public List<Expense> searchAll() {
        return expenseRepository.findAll();
    }

}
