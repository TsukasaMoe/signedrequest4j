package com.github.seratch.signedrequest4j.snippet;

import com.github.seratch.signedrequest4j.*;

import java.util.HashMap;
import java.util.Map;

public class ThreeLeggedSignatureWithAdditionalParamsSnippet {
	public static void main(String[] args) throws Exception {
		Map<String, Object> additionalParams = new HashMap<String, Object>();
		additionalParams.put("xoauth_requestor_id", "user@example.com");
		SignedRequest signedRequest = SignedRequestFactory.get3LeggedOAuthRequest(
				new OAuthConsumer("consumer_key", "consumer_secret"),
				new OAuthToken("access_token", "token_secret"),
				additionalParams);
		HttpResponse response = signedRequest.doGet("http://sp.example.com/api/?aaa=bbb", "UTF-8");
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());
		System.out.println(response.getContent());
	}
}
