package com.example.kakeibo.controller;

import com.example.kakeibo.domain.Expense;
import com.example.kakeibo.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Expense getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    public Expense create(@Valid @RequestBody Expense expense) {
        return service.create(expense);
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Integer id,
                          @Valid @RequestBody Expense newData) {
        return service.update(id, newData);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
