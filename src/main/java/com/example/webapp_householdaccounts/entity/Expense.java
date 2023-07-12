package com.example.webapp_householdaccounts.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 支出情報エンティティ
 */

@Data
@Table(name = "EXPENSE")
@Entity
public class Expense implements Serializable {
    // ID
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // 名前
    @Column(name = "NAME")
    private String name;

    // 値段
    @Column(name = "PRICE")
    private int price;

    // カテゴリ
    @Column(name = "CATEGORY")
    private String category;

    // 登録ユーザ
    @Column(name = "registered")
    private String registered;

    // 更新日時
    @Column(name = "UPDATE_DATE")
    private Date updateDate;

    // 登録日時
    @Column(name = "CREATE_DATE")
    private Date createDate;

    // 削除日時
    @Column(name = "DELETE_DATE")
    private Date deleteDate;

    // チェック済みかどうか
    @Column(name = "CHECKED")
    private boolean checked;


}
