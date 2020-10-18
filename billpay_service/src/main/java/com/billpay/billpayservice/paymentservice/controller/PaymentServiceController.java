package com.billpay.billpayservice.paymentservice.controller;


import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.billpay.billpaymodel.domain.MakePaymentData;
import com.billpay.billpayservice.util.BillpayConstants;
import com.billpay.billpaymodel.view.MakePaymentRequest;
import com.billpay.billpaymodel.view.MakePaymentResponse;
import com.billpay.billpayservice.paymentservice.viewformatter.MakePaymentViewFormatter;
import com.billpay.billpayservice.paymentservice.aggregator.MakePaymentAggregator;


@RestController
@RequestMapping(BillpayConstants.BILLPAY_MAPPING_URL)
public class PaymentServiceController {
	
	//private Logger Logger = (org.slf4j.Logger) LogFactory.getLog(PaymentServiceController.class);
	
	@Autowired
	MakePaymentViewFormatter makePaymentViewFormatter;
	
	@Autowired
	MakePaymentAggregator makePaymentAggregator;
	
	@PostMapping(value = BillpayConstants.CREATE_PAYMENT, consumes = "application/json", produces = "application/json")
	public MakePaymentResponse makePayment(@RequestBody MakePaymentRequest makePaymentRequest) {
		
		System.out.println("Make Payment UI request: " + makePaymentRequest.toString());
		//Logger.info("Make Payment UI request: {}",makePaymentRequest);
		MakePaymentData makePaymentData = makePaymentViewFormatter.formatMakePaymentRequestToData(makePaymentRequest);
		MakePaymentResponse makePaymentResponse = makePaymentAggregator.makePayment(makePaymentData);
		//Logger.info("Make Payment UI response: {}",makePaymentResponse);
		System.out.println("Make Payment UI response: " + makePaymentResponse.toString());
		return makePaymentResponse;
	}

}
