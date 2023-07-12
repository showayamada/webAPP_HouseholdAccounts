package com.example.webapp_householdaccounts.dto;


import java.io.Serializable;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * 支出情報　リクエストデータ
 */
@Data
public class ExpenseRequest implements Serializable{
    // 名前
    @NotEmpty(message = "名前を入力してください")
    @Size(max = 100, message = "100文字以内")
    private String name;

    // 値段
    @Size(max = 30, message = "30桁以内")
    private int price;

    // カテゴリ
    @Size(message = "カテゴリを入力してください")
    private String category;



}
