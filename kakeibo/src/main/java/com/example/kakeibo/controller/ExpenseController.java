package com.example.kakeibo.controller;

import com.example.kakeibo.domain.Expense;
import com.example.kakeibo.dto.ExpenseRequest;
import com.example.kakeibo.dto.ExpenseResponse;
import com.example.kakeibo.service.ExpenseService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ExpenseResponse> getAll(Pageable pageable) {
        return service.findAll(pageable)
                .map(ExpenseResponse::new);

    }

    @GetMapping("/{id}")
    public ExpenseResponse getById(@PathVariable Integer id) {
        return new ExpenseResponse(service.findById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ExpenseResponse create(@Valid @RequestBody ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setDate(request.getDate());
        expense.setCategory(request.getCategory());
        expense.setAmount(request.getAmount());
        expense.setMemo(request.getMemo());

        Expense saved = service.create(expense);

        return new ExpenseResponse(saved);
    }

    @PutMapping("/{id}")
    public ExpenseResponse update(@PathVariable Integer id,
                          @Valid @RequestBody ExpenseRequest request) {
        Expense expense = new Expense();
        expense.setDate(request.getDate());
        expense.setCategory(request.getCategory());
        expense.setAmount(request.getAmount());
        expense.setMemo(request.getMemo());

        Expense updated = service.update(id, expense);

        return new ExpenseResponse(updated);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
