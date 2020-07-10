package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.HeaderValueParser;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

import io.restassured.response.Response;
/*
 * Deepak
 */
public class getAPITest extends TestBase{
	
	TestBase testBase;
	
	String URL;
	RestClient restClient; 
	CloseableHttpResponse httpResp;
	public HashMap<String, String> header() {
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", prop.getProperty("ContentType"));
		headerMap.put("api-section",  prop.getProperty("APISection"));
		headerMap.put("api-version", prop.getProperty("APIVersion"));
		headerMap.put("auth-token",prop.getProperty("AuthToken") );
		//headerMap.put("auth-id", prop.getProperty("authid"));
		return headerMap;
	}
	//API Test for Login
	@Test(priority = 1)
	public void GetLoginAPI() throws ClientProtocolException, IOException, JSONException {
		restClient = new RestClient();
		testBase=new TestBase();
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid1"));
		headerMap2.putAll(header());
		URL = prop.getProperty("LoginURL");
		httpResp=restClient.testOptHolidays(URL,headerMap2);
		
	//Status Code
	int staCode = httpResp.getStatusLine().getStatusCode();		
	System.out.println("Status code is : "+staCode );
	Assert.assertEquals(staCode, RESPONSE_STATUS_CODE_200	,"Status code is not 200");
	
	//Json String
	String respString = EntityUtils.toString(httpResp.getEntity(),"UTF-8");	
	JSONObject respJson = new JSONObject(respString);
	System.out.println("JSON Response From API : "+ respJson);
	
	String idValue = TestUtil.getValueByJPath(respJson, "/user/id");
	String uidValue = TestUtil.getValueByJPath(respJson, "/user/uid");
	String locationValue = TestUtil.getValueByJPath(respJson, "/user/location");
	System.out.println("Value of type -: "+idValue);
	System.out.println("Value of date : "+uidValue);
	System.out.println("Value of date : "+locationValue);
	
	Assert.assertEquals(Integer.parseInt(idValue), 319);
	Assert.assertEquals(Integer.parseInt(uidValue), 20190807);
	Assert.assertEquals(locationValue, "bangalore");
	

	//All Headers
	Header[] allArray = httpResp.getAllHeaders();
	HashMap<String, String> allHeaders = new HashMap<String, String>();
	for (Header header : allArray) {
		allHeaders.put(header.getName(), header.getValue());
	}
	
	System.out.println("Headers Array : "+ allHeaders);
	}
	//API Test for GeoFences
	@Test(priority = 2)
	public void GetGeoFencesAPI() throws ClientProtocolException, IOException, JSONException {
		restClient = new RestClient();
		testBase=new TestBase();
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid2"));
		headerMap2.putAll(header());
		URL = prop.getProperty("GeoFencesURL");
		httpResp=restClient.testOptHolidays(URL,headerMap2);
		
	//Status Code
	int staCode = httpResp.getStatusLine().getStatusCode();		
	System.out.println("Status code is :: "+staCode );
	Assert.assertEquals(staCode, RESPONSE_STATUS_CODE_200	,"Status code is not 200");
	
	//Json String
	String respString = EntityUtils.toString(httpResp.getEntity(),"UTF-8");	
	JSONObject respJson = new JSONObject(respString);
	System.out.println("JSON Response From API : "+ respJson);
	
	String nameValue = TestUtil.getValueByJPath(respJson, "/latlng[0]/name");
	String latValue = TestUtil.getValueByJPath(respJson, "/latlng[0]/lat");
	String lngValue = TestUtil.getValueByJPath(respJson, "/latlng[0]/lng");
	System.out.println("Value of type : "+nameValue);
	System.out.println("Value of date : "+latValue);
	System.out.println("Value of date : "+lngValue);
	
	Assert.assertEquals(nameValue, "Brigosha Technologies Pvt. Ltd.");
	Assert.assertEquals(latValue, "12.91278300");
	Assert.assertEquals(lngValue, "77.64473900");
	

	//All Headers
	Header[] allArray = httpResp.getAllHeaders();
	HashMap<String, String> allHeaders = new HashMap<String, String>();
	for (Header header : allArray) {
		allHeaders.put(header.getName(), header.getValue());
	}
	
	System.out.println("Headers Array : "+ allHeaders);
	}
	@Test(priority = 3)
	public void GetViewCalenderAPI() throws ClientProtocolException, IOException, JSONException {
		restClient = new RestClient();
		testBase=new TestBase();
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid3"));
		headerMap2.putAll(header());
		URL = prop.getProperty("ViewCalender");
		httpResp=restClient.testOptHolidays(URL,headerMap2);
		
	//Status Code
	int staCode = httpResp.getStatusLine().getStatusCode();		
	System.out.println("Status code is : "+staCode );
	Assert.assertEquals(staCode, RESPONSE_STATUS_CODE_200	,"Status code is not 200");
	
	//Json String
	String respString = EntityUtils.toString(httpResp.getEntity(),"UTF-8");	
	JSONObject respJson = new JSONObject(respString);
	System.out.println("JSON Response From API : "+ respJson);
	
	String idValue = TestUtil.getValueByJPath(respJson, "/logDetails/id");
	String uidValue = TestUtil.getValueByJPath(respJson, "/logDetails/user_id");
	String WHoursValue = TestUtil.getValueByJPath(respJson, "/logDetails/working_hour");
	System.out.println("Value of type -: "+idValue);
	System.out.println("Value of date : "+uidValue);
	System.out.println("Value of date : "+WHoursValue);
	
	Assert.assertEquals(Integer.parseInt(idValue), 7562);
	Assert.assertEquals(Integer.parseInt(uidValue), 226);
	Assert.assertEquals(Integer.parseInt(WHoursValue), 162);
	

	//All Headers
	Header[] allArray = httpResp.getAllHeaders();
	HashMap<String, String> allHeaders = new HashMap<String, String>();
	for (Header header : allArray) {
		allHeaders.put(header.getName(), header.getValue());
	}
	
	System.out.println("Headers Array : "+ allHeaders);
	}
	//API Test for OptionalHoliday
	@Test(priority = 4)
	public void GetOptHolidayAPI() throws ClientProtocolException, IOException, JSONException {
		restClient = new RestClient();
		testBase=new TestBase();
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid4"));
		headerMap2.putAll(header());
		URL = prop.getProperty("OptHolidayURL");
		httpResp=restClient.testOptHolidays(URL,headerMap2);
		
	//Status Code
	int staCode = httpResp.getStatusLine().getStatusCode();		
	System.out.println("Status code is : "+staCode );
	Assert.assertEquals(staCode, RESPONSE_STATUS_CODE_200	,"Status code is not 200");
	
	//Json String
	String respString = EntityUtils.toString(httpResp.getEntity(),"UTF-8");	
	JSONObject respJson = new JSONObject(respString);
	System.out.println("JSON Response From API : "+ respJson);
	
	String typeValue = TestUtil.getValueByJPath(respJson, "/holidays[0]/type");
	String dayValue = TestUtil.getValueByJPath(respJson, "/holidays[0]/day");
	String dateValue = TestUtil.getValueByJPath(respJson, "/holidays[0]/date");
	System.out.println("Value of type : "+typeValue);
	System.out.println("Value of date : "+dateValue);
	System.out.println("Value of date : "+dayValue);
	
	Assert.assertEquals(typeValue, "fixed");
	Assert.assertEquals(dateValue, "15-Jan-2020");
	Assert.assertEquals(dayValue, "Makara Sankranthi / Pongal");
	

	//All Headers
	Header[] allArray = httpResp.getAllHeaders();
	HashMap<String, String> allHeaders = new HashMap<String, String>();
	for (Header header : allArray) {
		allHeaders.put(header.getName(), header.getValue());
	}
	
	System.out.println("Headers Array : "+ allHeaders);
	}

}
