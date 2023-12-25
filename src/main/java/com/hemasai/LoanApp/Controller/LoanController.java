package com.hemasai.LoanApp.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hemasai.LoanApp.Helper.Constants;
import com.hemasai.LoanApp.Models.Application;
import com.hemasai.LoanApp.Models.Loan;
import com.hemasai.LoanApp.Models.Response;

import java.util.HashMap;
import java.util.List;

@RestController
public class LoanController {
    private Logger logger = LoggerFactory.getLogger(LoanController.class);
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private Loan loan;

    @PostMapping("/loan")
    public Response addLoan(
            @RequestBody() JsonNode request
            ) {
        logger.info("Entered into addLoan with request : {}", request);
        Response response = new Response();
        String name = request.get(Constants.NAME).asText();
        Application application = mapper.convertValue(request.get(Constants.APPLICATION), Application.class);
        String message = loan.registerApplication(name, application);
        response.setStatus(Constants.SUCCESS);
        response.setMessage(message);
        logger.info("Exit from addLoan with response : {}", response);
        return response;
    }

    @GetMapping("/loans")
    public Response getLoans() {
        logger.info("Entered into getLoans");
        Response response = new Response();
        HashMap<String, List<Application>> loans = loan.getLoans();
        response.setStatus(Constants.SUCCESS);
        response.setData(loans);
        logger.info("Exit from getLoans with response : {}", response);
        return response;
    }

    @PostMapping("/loan/cancel")
    public Response cancelLoan(
            @RequestBody() JsonNode request
    ) {
        logger.info("Entered into cancelLoan with request : {}", request);
        Response response = new Response();
        String name = request.get(Constants.NAME).asText();
        Application application = mapper.convertValue(request.get(Constants.APPLICATION), Application.class);
        String message = loan.cancelApplication(name, application);
        response.setStatus(Constants.SUCCESS);
        response.setMessage(message);
        logger.info("Exit from cancelLoan with response : {}", response);
        return response;
    }

}
