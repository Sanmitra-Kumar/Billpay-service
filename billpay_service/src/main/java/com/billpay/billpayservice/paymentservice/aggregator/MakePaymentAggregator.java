package com.billpay.billpayservice.paymentservice.aggregator;

import org.springframework.beans.factory.annotation.Autowired;

import com.billpay.billpaymodel.crud.model.CrudMakePaymentRequest;
import com.billpay.billpaymodel.crud.model.CrudManagePaymentResponse;
import com.billpay.billpaymodel.domain.MakePaymentData;
import com.billpay.billpaymodel.view.MakePaymentResponse;
import com.billpay.billpayservice.paymentservice.formatter.IPaymentServiceFormatter;
import com.billpay.billpayservice.paymentservice.formatter.PaymentServiceFormatter;
import com.billpay.billpayservice.util.RestUtil;

public class MakePaymentAggregator {

	@Autowired
	IPaymentServiceFormatter paymentServiceFormatter;

	@Autowired
	RestUtil restUtil;

	public MakePaymentResponse makePayment(MakePaymentData makePaymentData) {

		MakePaymentResponse makePaymentResponse = null;

		CrudMakePaymentRequest crudMakePaymentRequest = paymentServiceFormatter
				.formatMakePaymentCrudRequest(makePaymentData);

		CrudManagePaymentResponse crudManagePaymentResponse = restUtil
				.crudMakePaymentServiceCall(crudMakePaymentRequest).getBody();

		makePaymentResponse = paymentServiceFormatter.formatMakePaymentResponse(crudManagePaymentResponse);

		return makePaymentResponse;
	}

}
