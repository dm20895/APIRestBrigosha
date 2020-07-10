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
	//Get method for login	
	public CloseableHttpResponse testLogin(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);  
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(),entry.getValue() );
		}
		CloseableHttpResponse httpResp = httpClient.execute(httpget);
		return httpResp;
}
	//Get method for Geo Fences
	public CloseableHttpResponse testGeoFences(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);  
		for(Map.Entry<String, String> entry : headerMap.entrySet()) {
			httpget.addHeader(entry.getKey(),entry.getValue() );
		}
		CloseableHttpResponse httpResp = httpClient.execute(httpget);
		return httpResp;
}
	//Get method for View Calender Fences
		public CloseableHttpResponse testViewCalender(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);  
			for(Map.Entry<String, String> entry : headerMap.entrySet()) {
				httpget.addHeader(entry.getKey(),entry.getValue() );
			}
			CloseableHttpResponse httpResp = httpClient.execute(httpget);
			return httpResp;
		}
	
	//Get method for Optional Holiday
		public CloseableHttpResponse testOptHolidays(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);  
			for(Map.Entry<String, String> entry : headerMap.entrySet()) {
				httpget.addHeader(entry.getKey(),entry.getValue() );
			}
			CloseableHttpResponse httpResp = httpClient.execute(httpget);
			return httpResp;
	}
		//get method for monthly feedback
		public CloseableHttpResponse testMonthlyFeedback(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);  
			for(Map.Entry<String, String> entry : headerMap.entrySet()) {
				httpget.addHeader(entry.getKey(),entry.getValue() );
			}
			CloseableHttpResponse httpResp = httpClient.execute(httpget);
			return httpResp;
	}
		//get method for Attendance
		public CloseableHttpResponse testAttendance(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);  
			for(Map.Entry<String, String> entry : headerMap.entrySet()) {
				httpget.addHeader(entry.getKey(),entry.getValue() );
			}
			CloseableHttpResponse httpResp = httpClient.execute(httpget);
			return httpResp;
	}
		//get method for Attendance
		public CloseableHttpResponse testManualPunch(String url,HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(url);  
			for(Map.Entry<String, String> entry : headerMap.entrySet()) {
				httpget.addHeader(entry.getKey(),entry.getValue() );
			}
			CloseableHttpResponse httpResp = httpClient.execute(httpget);
			return httpResp;
		}
}