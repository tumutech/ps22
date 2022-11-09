package com.example.ps22.model;

public class expenses {
    String expensename,ecost;
    public expenses(String ename,String ecost){
        this.expensename = ename;
        this.ecost = ecost;
    }

    public String getEcost() {
        return ecost;
    }

    public String getExpensename() {
        return expensename;
    }

    public void setEcost(String ecost) {
        this.ecost = ecost;
    }

    public void setExpensename(String expensename) {
        this.expensename = expensename;
    }
}
