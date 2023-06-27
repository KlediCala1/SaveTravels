package com.dojo.travel.savetravels.services;

import com.dojo.travel.savetravels.models.Budget;
import com.dojo.travel.savetravels.repositories.BudgetRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {
    @Autowired
    private BudgetRepositories budgetRepositories;


    public static void updateBudget(Budget budget) {
    }


    public  List<Budget> getAllBudgets(){
            return budgetRepositories.findAll();
        }

   public Budget createBudget(Budget budget){
        return budgetRepositories.save(budget);
   }

    public Budget findBudget(Long id){
        Optional<Budget> optionalBudget = budgetRepositories.findById(id);
        if (optionalBudget.isPresent()){
            return optionalBudget.get();
        }
        else{
            return null;
        }
    }
    public void deleteBudget(Long id){
        budgetRepositories.deleteById(id);
    }
}
    


