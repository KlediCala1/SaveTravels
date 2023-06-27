package com.dojo.travel.savetravels.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name = "budgets")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull
    @Size(min = 3, max = 40 , message = "put the right size")
    private String Expense;

    private String Vendor;
    @NotNull
    @Min(0)
    private Double Amount ;
    @NotBlank
    @Size(min = 8 , max=100)
    private String Description;

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Budget(String Expense, String Vendor , Double Amount , String Description, Long Id) {
        this.Amount=Amount;
        this.Expense=Expense;
        this.Vendor=Vendor;
        this.Id=Id;
        this.Description=Description;
    }

    public Budget() {

    }

    public String getExpense() {
        return Expense;
    }

    public String getVendor() {
        return Vendor;
    }

    public void setVendor(String vendor) {
        Vendor = vendor;
    }

    public void setExpense(String expense) {
        Expense = expense;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Long getId() {
        return Id;
    }

    public String getDescription(){
        return Description;
    }
    public void setDescription(String Description){
        this.Description= Description;
    }
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
