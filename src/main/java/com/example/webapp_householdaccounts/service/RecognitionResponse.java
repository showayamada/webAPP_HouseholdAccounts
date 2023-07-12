package com.example.webapp_householdaccounts.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecognitionResponse {
    @JsonProperty("price")
    private int price;

    public RecognitionResponse() {
        // デフォルトコンストラクタ
    }

    public RecognitionResponse(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

