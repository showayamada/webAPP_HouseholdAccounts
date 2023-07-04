package com.example.webapp_householdaccounts.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

/**
 * 支出情報エンティティ
 */
@Entity
@Data
@Table(name = "expense")
public class Expense implements Serializable{
    // ID
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 名前
    @Column(name = "name")
    private String name;

    // 値段
    @Column(name = "price")
    private int price;

    // カテゴリ
    @Column(name = "category")
    private String category;

    // 登録ユーザ
    @Column(name = "registered")
    private String registered;

    // 更新日時
    @Column(name = "update_date")
    private Date updateDate;

    // 登録日時
    @Column(name = "create_date")
    private Date createDate;

    // 削除日時
    @Column(name = "delete_dete")
    private Date deleteDate;

    // チェック済みかどうか
    @Column(name = "check")
    private boolean check;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
