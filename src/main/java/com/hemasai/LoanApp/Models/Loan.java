package com.hemasai.LoanApp.Models;


import org.springframework.stereotype.Component;

import com.hemasai.LoanApp.Helper.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class Loan {
    private HashMap<String, List<Application>> loans;

    public HashMap<String, List<Application>> getLoans() {
        return loans;
    }

    public void setLoans(HashMap<String, List<Application>> loans) {
        this.loans = loans;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loans=" + loans +
                '}';
    }

    public String registerApplication(String name, Application application) {
        List<Application> applications = new ArrayList<>();
        if (this.loans != null && this.loans.containsKey(name)) {
            applications = loans.get(name);
            applications.add(application);
            this.loans.put(name, applications);
        } else {
            applications.add(application);
            HashMap<String, List<Application>> map = new HashMap<>();
            map.put(name, applications);
            setLoans(map);
        }
        return "Successfully Added";
    }

    public String cancelApplication(String name, Application application) {
        if (this.loans != null && this.loans.containsKey(name)) {
            List<Application> applications = loans.get(name);
            applications.forEach(application1 -> {
                if(application1.getName().equalsIgnoreCase(application.getName())) {
                    application1.setStatus(Constants.CANCELLED);
                }
            });
            this.loans.put(name, applications);
            return "Loan cancelled";
        } else {
            return "No loans for given application";
        }
    }

}
