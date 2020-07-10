package com.qa.client;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;



public class RestClient {
	//Get Result	
	public CloseableHttpResponse getResult(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);  
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(),entry.getValue() );
		}
		CloseableHttpResponse httpResp = httpClient.execute(httpget);
		return httpResp;
 }
}	