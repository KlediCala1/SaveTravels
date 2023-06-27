package com.dojo.travel.savetravels.repositories;

import com.dojo.travel.savetravels.models.Budget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BudgetRepositories extends CrudRepository<Budget, Long>{

          List<Budget>findAll();

          Optional<Budget>findById(Long id);
          void deleteById(Long id);
    }


