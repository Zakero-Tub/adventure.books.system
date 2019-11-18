package com.advance.academy.adventure.books.system.service;

import com.advance.academy.adventure.books.system.model.dto.BittrexTickerResponse;
import com.advance.academy.adventure.books.system.model.dto.PayPalCaptureRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class TestService {

    private final RestTemplate restTemplate;

    @Autowired
    public TestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String testPayPalCapture() {
        ResponseEntity<String> response = null;
        try {
            PayPalCaptureRequest payPalCaptureRequest = new PayPalCaptureRequest();
            payPalCaptureRequest.setFinalCapture(Boolean.FALSE);
            payPalCaptureRequest.setInvoiceId("test invoice");
            payPalCaptureRequest.setAmountValue(new BigDecimal(19));
            payPalCaptureRequest.setAmountCurrencyCode("USD");

            HttpEntity<PayPalCaptureRequest> request = new HttpEntity<>(payPalCaptureRequest, new HttpHeaders());

            response = restTemplate.exchange(
                    "https://api.sandbox.paypal.com/v2/payments/authorizations/{authorization_id}/capture",
                    HttpMethod.POST,
                    request,
                    String.class,
                    "authorization_id134131"
            );

            return response.getBody();
        } catch (HttpClientErrorException e) {
            return e.getResponseBodyAsString() +" "+ e.getMessage() +" "+ e.getStatusCode();
        }
    }

    public BittrexTickerResponse getBittrexTicker() throws JsonProcessingException {
        return restTemplate.getForObject(
                "https://api.bittrex.com/api/v1.1/public/gett1icker?market=USD-BTC",
                BittrexTickerResponse.class
        );

//        BittrexTickerResponse response = new ObjectMapper().readValue(result,BittrexTickerResponse.class);
//        return null;
    }
}
