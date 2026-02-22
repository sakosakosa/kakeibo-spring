package com.example.kakeibo.service;

import com.example.kakeibo.domain.Expense;
import com.example.kakeibo.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Transactional
@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public List<Expense> findAll() {
        return repository.findAll();
    }

    public Expense findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Expense create(Expense expense) {
        return repository.save(expense);
    }

    public Expense update(Integer id, Expense newData) {
        Expense existing = findById(id);

        existing.setDate(newData.getDate());
        existing.setCategory(newData.getCategory());
        existing.setAmount(newData.getAmount());
        existing.setMemo(newData.getMemo());

        return repository.save(existing);
    }

    public void delete(Integer id) {
        Expense existing = findById(id);
        repository.delete(existing);
    }
}
