package com.billpay.billpayservice.util;

import com.billpay.billpaymodel.crud.model.CrudMakePaymentRequest;
import com.billpay.billpaymodel.crud.model.CrudManagePaymentResponse;
import com.billpay.billpayservice.integrator.CrudIntegrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class RestUtil {

	@Autowired
	LoadBalancerClient ribbonLoadBalancerClient;

	@Autowired
	CrudIntegrator crudIntegrator;

	private String createCrudServiceUrl(String serviceName, String serviceEndpoint) {
		String url = "";
		ServiceInstance instance = this.ribbonLoadBalancerClient.choose(serviceName);
		if (null != instance) {
			url = instance.getUri().toString().concat(serviceEndpoint);
		}
		return url;
	}

	private String createCrudServiceStaticUrl(String crudServiceName, String crudCreateServiceEndpoint) {
		String url = "";
		url = crudServiceName.concat(crudCreateServiceEndpoint);
		return url;
	}

	public ResponseEntity<CrudManagePaymentResponse> crudMakePaymentServiceCall(
			CrudMakePaymentRequest crudMakePaymentRequest) {

		String crudCreateServiceEndpoint = "/crud/billpay/moneymovement/payments";
		String crudServiceName = "http://localhost:8081";
		HttpEntity<CrudMakePaymentRequest> entity = new HttpEntity<>(crudMakePaymentRequest);
		String crudServiceUrl = createCrudServiceStaticUrl(crudServiceName, crudCreateServiceEndpoint);
		return (crudIntegrator.doCrudMakePaymentSvcCall(crudServiceUrl, HttpMethod.POST, entity,
				CrudManagePaymentResponse.class));

	}

}
