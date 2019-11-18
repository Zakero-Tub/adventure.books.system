package com.advance.academy.adventure.books.system.controller;


import com.advance.academy.adventure.books.system.model.dto.BittrexTickerResponse;
import com.advance.academy.adventure.books.system.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test-rest")
public class TestController {

    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("/test-paypal")
    public String testPaypal(){
        return testService.testPayPalCapture();
    }

    @GetMapping("/test-brittex")
    public BittrexTickerResponse getBettrixResponce() throws JsonProcessingException {
        //return testService.getBittrexTicker();
        BittrexTickerResponse response = testService.getBittrexTicker();
        return response;
    }
}
