package com.example.a52weekchallenge;


// model class denoting the week container properties
public class WeeklyContainers {
    private String name;
    private float deposit;
    private float total;

    public WeeklyContainers() {
    }

    public WeeklyContainers(String name, int deposit, int total) {
        this.name = name;
        this.deposit = deposit;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}

