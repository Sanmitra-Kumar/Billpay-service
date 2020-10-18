package com.billpay.billpayservice.integrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.billpay.billpaymodel.crud.model.CrudMakePaymentRequest;
import com.billpay.billpaymodel.crud.model.CrudManagePaymentResponse;

public class CrudIntegrator {

	@Autowired
	RestTemplate restTemplate;
	
	public ResponseEntity<CrudManagePaymentResponse> doCrudMakePaymentSvcCall(String uriComp, HttpMethod method,
			HttpEntity<?> entity, Class<CrudManagePaymentResponse> responseType) {

		ResponseEntity<CrudManagePaymentResponse> response = restTemplate.exchange(uriComp, method, entity,
				responseType);
		return response;
	}

}
