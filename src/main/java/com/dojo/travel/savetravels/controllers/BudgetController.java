package com.dojo.travel.savetravels.controllers;

import com.dojo.travel.savetravels.models.Budget;
import com.dojo.travel.savetravels.services.BudgetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class BudgetController {
    @Autowired
    BudgetService budgetService;

    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
    @RequestMapping("/")
    public String home(){
        return "redirect:/expenses";
    }

    @RequestMapping ("/expenses")
    public String index(@ModelAttribute ("travel") Budget budget, Model model) {
        List<Budget> budgets = budgetService.getAllBudgets();
        model.addAttribute("allBudgets", budgets);
        return "index";
    }
    @PostMapping("")
    public String add(@Valid @ModelAttribute("travel") Budget budget,
                            Model model, BindingResult result) {
        if (result.hasErrors()) {
            List<Budget> budgets = budgetService.getAllBudgets();
            model.addAttribute("allBudgets", budgets);
            return "index";
        } else {

            budgetService.createBudget(budget);
            return "redirect:/expenses";
        }
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Budget optionalBudget = budgetService.findBudget(id);
        model.addAttribute("travel",optionalBudget);
        return "edit";
    }

    @PutMapping("/{id}")
    public String update(@Valid @ModelAttribute("travel") Budget budget,
                         Model model, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("budgets", budget);
            return "edit";
        }
        else{
            BudgetService.updateBudget(budget);
            return "redirect:/expenses";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        budgetService.deleteBudget(id);
        return "redirect:/expenses";
    }

}
