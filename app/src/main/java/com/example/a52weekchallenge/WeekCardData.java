package com.example.a52weekchallenge;


//model class for the data on the card
class WeekCardData {

    String week_number;
    String deposit_amount;
    String total_amount;

    public WeekCardData(String week_number, String deposit_amount, String total_amount) {
        this.week_number = week_number;
        this.deposit_amount = deposit_amount;
        this.total_amount = total_amount;


    }

    public String getWeek_number() {
        return week_number;
    }

    public WeekCardData setWeek_number(String week_number) {
        this.week_number = week_number;
        return this;
    }

    public String getDeposit_amount() {
        return deposit_amount;
    }

    public WeekCardData setDeposit_amount(String deposit_amount) {
        this.deposit_amount = deposit_amount;
        return this;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public WeekCardData setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
        return this;
    }
}
