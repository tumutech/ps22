package com.example.ps22.model;

public class debitors {
    String cname,acredited,cpaid,balance;
    public debitors(String clientname,String amount,String paida){
        this.cname = clientname;
        this.acredited = amount;
        this.cpaid = paida;
    }

    public String getAcredited() {
        return acredited;
    }
    public String getBalance() {
        double realamount = Double.parseDouble(acredited);
        double paima = Double.parseDouble(cpaid);
        double blc = realamount - paima;
        this.balance = String.valueOf(blc);
        return balance;
    }

    public String getCname() {
        return cname;
    }

    public String getCpaid() {
        return cpaid;
    }

    public void setAcredited(String acredited) {
        this.acredited = acredited;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setCpaid(String cpaid) {
        this.cpaid = cpaid;
    }
}
