package com.billpay.billpayservice.paymentservice.formatter;

import com.billpay.billpaymodel.crud.model.CrudMakePaymentRequest;
import com.billpay.billpaymodel.crud.model.CrudManagePaymentResponse;
import com.billpay.billpaymodel.domain.MakePaymentData;
import com.billpay.billpaymodel.view.MakePaymentResponse;

public interface IPaymentServiceFormatter {
	
	public CrudMakePaymentRequest formatMakePaymentCrudRequest(MakePaymentData makePaymentData);

	public MakePaymentResponse formatMakePaymentResponse(CrudManagePaymentResponse crudManagePaymentResponse);
}
