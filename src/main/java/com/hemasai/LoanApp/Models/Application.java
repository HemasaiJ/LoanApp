package com.hemasai.LoanApp.Models;

import com.hemasai.LoanApp.Helper.Constants;

import java.awt.desktop.ScreenSleepEvent;

public class Application {
    private String name;
    private int amount;
    private String status = Constants.OPEN;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
