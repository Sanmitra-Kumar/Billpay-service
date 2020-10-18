package com.billpay.billpayservice.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.billpay.billpayservice.integrator.CrudIntegrator;
import com.billpay.billpayservice.paymentservice.aggregator.MakePaymentAggregator;
import com.billpay.billpayservice.paymentservice.formatter.PaymentServiceFormatter;
import com.billpay.billpayservice.paymentservice.viewformatter.MakePaymentViewFormatter;
import com.billpay.billpayservice.util.RestUtil;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages =  {"com.billpay.billpayservice.paymentservice.controller","com.billpay.billpayservice.paymentservice.viewformatter"})
public class BillpayServiceApplication {

	@Bean
    public PaymentServiceFormatter paymentServiceFormatter() {
        return new PaymentServiceFormatter();
    }
	
	@Bean
    public MakePaymentAggregator makePaymentAggregator() {
        return new MakePaymentAggregator();
    }
	
	@Bean
    public MakePaymentViewFormatter makePaymentViewFormatter() {
        return new MakePaymentViewFormatter();
    }
	
	@Bean
    public RestUtil restUtil() {
        return new RestUtil();
    }
	
	@Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
	
	@Bean
    public CrudIntegrator crudIntegrator() {
        return new CrudIntegrator();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BillpayServiceApplication.class, args);
		
	}

}
