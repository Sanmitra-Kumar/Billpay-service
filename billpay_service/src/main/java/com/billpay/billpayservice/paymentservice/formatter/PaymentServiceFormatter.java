package com.billpay.billpayservice.paymentservice.formatter;

import java.util.ArrayList;
import java.util.List;

import com.billpay.billpaymodel.crud.model.CrudBillPaymentInfoItem;
import com.billpay.billpaymodel.crud.model.CrudMakePaymentRequest;
import com.billpay.billpaymodel.crud.model.CrudManagePaymentResponse;
import com.billpay.billpaymodel.domain.MakePaymentData;
import com.billpay.billpaymodel.domain.PaymentData;
import com.billpay.billpaymodel.view.MakePaymentResponse;

public class PaymentServiceFormatter implements IPaymentServiceFormatter{

	public CrudMakePaymentRequest formatMakePaymentCrudRequest(MakePaymentData makePaymentData) {
		CrudMakePaymentRequest crudMakePaymentRequest = new CrudMakePaymentRequest();
		List<CrudBillPaymentInfoItem> crudBillPaymentInfoList = new ArrayList<>();
		CrudBillPaymentInfoItem crudBillPaymentInfoItem = new CrudBillPaymentInfoItem();
		PaymentData paymentData = makePaymentData.getPayment();

		crudBillPaymentInfoItem.setPaymentMethod(paymentData.getPaymentMethod().toString());
		crudBillPaymentInfoItem.setPayeeNickname(paymentData.getPayeeNickname());
		crudBillPaymentInfoItem.setTransactionAmount(paymentData.getPaymentAmount());
		crudBillPaymentInfoItem.setPaymentDate(paymentData.getPaymentDate().replaceAll("-", ""));

		crudBillPaymentInfoList.add(crudBillPaymentInfoItem);

		crudMakePaymentRequest.setPayments(crudBillPaymentInfoList);
		crudMakePaymentRequest.setPaymentType(paymentData.getPaymentCategory().getValue());
		crudMakePaymentRequest.setSourceAccount(makePaymentData.getSourceAccount());
		crudMakePaymentRequest.setPaymentActionType("1");

		return crudMakePaymentRequest;
	}

	public MakePaymentResponse formatMakePaymentResponse(CrudManagePaymentResponse crudManagePaymentResponse) {

		MakePaymentResponse makePaymentResponse = new MakePaymentResponse();

		makePaymentResponse.setPaymentReferenceNumber(crudManagePaymentResponse.getPaymentReferenceNumber());
		makePaymentResponse.setResponseCode(crudManagePaymentResponse.getResponseCode());

		return makePaymentResponse;
	}

}
