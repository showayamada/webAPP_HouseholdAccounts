package com.example.webapp_householdaccounts.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.webapp_householdaccounts.entity.Expense;
import com.example.webapp_householdaccounts.service.ExpenseService;

/**
 * 支出情報コントローラー
 */
@Controller
public class ExpenseController {
    // 支出サービス
    @Autowired
    private ExpenseService expenseService;

    /**
     * 支出一覧画面を表示
     * @param model Model
     * @return 支出一覧画面
     */
    @GetMapping(value = "/expense/list")
    public String displayList(Model model) {
        List<Expense> expenseList = expenseService.searchAll();
        model.addAttribute("expenseList", expenseList);
        return "expense/list";
    }

    /**
     * 新規登録画面を表示
     * @param model Model
     * @return 支出一覧画面
     */
    @GetMapping(value = "/expense/register")
    public String displayRegister(Model model) {
        return "expense/register";
    }

    /**
     * 支出詳細画面（仮）を表示
     * @param id 表示する支出ID
     * @param model Model
     * @return 詳細画面
     */
    @GetMapping("/expense/{id}")
    public String displayView(@PathVariable Long id, Model model) {
        return "expense/view";
    }


}
