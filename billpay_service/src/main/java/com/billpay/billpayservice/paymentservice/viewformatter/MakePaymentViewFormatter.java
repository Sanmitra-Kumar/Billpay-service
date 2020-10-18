package com.billpay.billpayservice.paymentservice.viewformatter;

import java.math.BigDecimal;

import com.billpay.billpaymodel.domain.MakePaymentData;
import com.billpay.billpaymodel.domain.PaymentData;
import com.billpay.billpaymodel.domain.PaymentData.PaymentCategory;
import com.billpay.billpaymodel.domain.PaymentData.PaymentMethod;
import com.billpay.billpaymodel.item.PaymentItem;
import com.billpay.billpaymodel.view.MakePaymentRequest;

public class MakePaymentViewFormatter {

	public MakePaymentData formatMakePaymentRequestToData(MakePaymentRequest makePaymentRequest) {
		MakePaymentData makePaymentData = new MakePaymentData();
		PaymentData paymentData = new PaymentData();
		PaymentItem payment = new PaymentItem();
		payment = makePaymentRequest.getPayment();
		
		paymentData.setPaymentMethod(PaymentMethod.valueOf(payment.getPaymentMethod().name()));
		paymentData.setPaymentCategory(PaymentCategory.valueOf(payment.getPaymentCategory().name()));
		paymentData.setPayeeNickname(payment.getPayeeNickname());
		paymentData.setPaymentAmount(payment.getPaymentAmount());
		paymentData.setPaymentDate(payment.getPaymentDate());
		
		makePaymentData.setSourceAccount(makePaymentRequest.getSourceAccount());
		makePaymentData.setPayment(paymentData);
		
		return makePaymentData;
	}

}
