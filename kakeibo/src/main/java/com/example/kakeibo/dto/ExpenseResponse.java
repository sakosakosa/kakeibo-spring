package com.example.kakeibo.dto;

import com.example.kakeibo.domain.Expense;
import java.time.LocalDate;

public class ExpenseResponse {

    private Integer id;
    private LocalDate date;
    private String category;
    private Integer amount;
    private String memo;

    // Entity → DTO 変換用コンストラクタ
    public ExpenseResponse(Expense expense) {
        this.id = expense.getId();
        this.date = expense.getDate();
        this.category = expense.getCategory();
        this.amount = expense.getAmount();
        this.memo = expense.getMemo();
    }

    // ===== Getterのみ（基本的にsetter不要） =====

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getMemo() {
        return memo;
    }
}