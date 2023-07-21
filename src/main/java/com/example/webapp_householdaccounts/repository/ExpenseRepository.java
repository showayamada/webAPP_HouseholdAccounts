package com.example.webapp_householdaccounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.webapp_householdaccounts.entity.Expense;

/**
 * 支出情報リポジトリ
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    // findByIdメソッドを定義
    Expense findById(long id);

}
