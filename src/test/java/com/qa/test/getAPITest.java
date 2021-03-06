package com.qa.test;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class getAPITest extends TestBase{
	TestBase testBase;
	RestClient restClient; 
	CloseableHttpResponse httpResp;
	
	@BeforeMethod
	public void setup() {
		restClient = new RestClient();
		testBase=new TestBase();
	}
	public HashMap<String, String> header() {
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", 	prop.getProperty("ContentType"));
		headerMap.put("api-section",  	prop.getProperty("APISection"));
		headerMap.put("api-version", 	prop.getProperty("APIVersion"));
		headerMap.put("auth-token",		prop.getProperty("AuthToken"));
		return headerMap;
	}

	//API Test for Login
	@Test(priority = 1)
	public void GetLoginAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> header = new HashMap<String, String>();
		header.put("auth-id", prop.getProperty("authid1"));
		header.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("LoginURL"), header);
		
	//Status code Json String & Headers
	JSONObject respJson = TestUtil.staCodeJsonStringHeaders(httpResp);
	
	String idValue = TestUtil.getValueByJPath(respJson, "/user/id");
	String uidValue = TestUtil.getValueByJPath(respJson, "/user/uid");
	String locationValue = TestUtil.getValueByJPath(respJson, "/user/location");
	System.out.println("Value of type : "+idValue);
	System.out.println("Value of date : "+uidValue);
	System.out.println("Value of date : "+locationValue);
	Assert.assertEquals(Integer.parseInt(idValue), 319);
	Assert.assertEquals(Integer.parseInt(uidValue), 20190807);
	Assert.assertEquals(locationValue, "bangalore");
}
	
	//API Test for GeoFences
	@Test(priority = 2)
	public void GetGeoFencesAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid2"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("GeoFencesURL"), headerMap2);
		
		//Status code Json String & Headers
		JSONObject respJson = TestUtil.staCodeJsonStringHeaders(httpResp);
	
	String nameValue = TestUtil.getValueByJPath(respJson, "/latlng[0]/name");
	String latValue = TestUtil.getValueByJPath(respJson, "/latlng[0]/lat");
	String lngValue = TestUtil.getValueByJPath(respJson, "/latlng[0]/lng");
	System.out.println("Value of type : "+nameValue);
	System.out.println("Value of date : "+latValue);
	System.out.println("Value of date : "+lngValue);
	
	Assert.assertEquals(nameValue, "Brigosha Technologies Pvt. Ltd.");
	Assert.assertEquals(latValue, "12.91278300");
	Assert.assertEquals(lngValue, "77.64473900");
}
	
	@Test(priority = 3)
	public void GetViewCalenderAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid3"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("ViewCalender"), headerMap2);
		
		//Status code Json String & Headers
		JSONObject respJson = TestUtil.staCodeJsonStringHeaders(httpResp);
	
	String idValue = TestUtil.getValueByJPath(respJson, "/logDetails/id");
	String uidValue = TestUtil.getValueByJPath(respJson, "/logDetails/user_id");
	String WHoursValue = TestUtil.getValueByJPath(respJson, "/logDetails/working_hour");
	System.out.println("Value of type -: "+idValue);
	System.out.println("Value of date : "+uidValue);
	System.out.println("Value of date : "+WHoursValue);
	
	Assert.assertEquals(Integer.parseInt(idValue), 7562);
	Assert.assertEquals(Integer.parseInt(uidValue), 226);
	Assert.assertEquals(Integer.parseInt(WHoursValue), 162);
}
	
	//API Test for OptionalHoliday
	@Test(priority = 4)
	public void GetOptHolidayAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid4"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("OptHolidayURL"), headerMap2);
		
	//Status code Json String & Headers
	JSONObject respJson = TestUtil.staCodeJsonStringHeaders(httpResp);
	
	String typeValue = TestUtil.getValueByJPath(respJson, "/holidays[0]/type");
	String dayValue = TestUtil.getValueByJPath(respJson, "/holidays[0]/day");
	String dateValue = TestUtil.getValueByJPath(respJson, "/holidays[0]/date");
	System.out.println("Value of type : "+typeValue);
	System.out.println("Value of date : "+dateValue);
	System.out.println("Value of date : "+dayValue);
	
	Assert.assertEquals(typeValue, "fixed");
	Assert.assertEquals(dateValue, "15-Jan-2020");
	Assert.assertEquals(dayValue, "Makara Sankranthi / Pongal");
}

	@Test(priority = 5)
	public void GetFeedbackMonthlyAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid4"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("FeedbackMon"), headerMap2);
		
	//Status code Json String & Headers
	JSONObject respJson = TestUtil.staCodeJsonStringHeaders(httpResp);
	
	String idValue = TestUtil.getValueByJPath(respJson, "/questions[0]/id");
	String typeValue = TestUtil.getValueByJPath(respJson, "/questions[0]/type");
	String textValue = TestUtil.getValueByJPath(respJson, "/questions[0]/text");
	System.out.println("Value of type : "+idValue);
	System.out.println("Value of date : "+typeValue);
	System.out.println("Value of date : "+textValue);
	
	Assert.assertEquals(Integer.parseInt(idValue), 1);
	Assert.assertEquals(typeValue, "sort");
	Assert.assertEquals(textValue, "Rearrange the following stakeholders measuring your professional relationship with them.");
}
	
	@Test(priority = 6)
	public void GetAttendanceAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid6"));
		headerMap2.put("X-Requested-With", prop.getProperty("XRequestedWith"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("AttendanceURL"), headerMap2);
		
		//Status code Json String & Headers
		JSONObject respJson = TestUtil.staCodeJsonStringHeaders(httpResp);
		String PageRedirectValue = TestUtil.getValueByJPath(respJson, "/events/page.redirect");
		System.out.println("Value of type : "+PageRedirectValue);
	
		Assert.assertEquals(PageRedirectValue, "/portal");
	}	
	@Test(priority = 7)
	public void GetManualPunchAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid7"));
		headerMap2.put("X-Requested-With", prop.getProperty("XRequestedWith"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("ManualPunch"), headerMap2);
		
		//Status code Json String & Headers
		TestUtil.staCodeJsonStringHeaders(httpResp);
	}	
	
	@Test(priority = 8)
	public void GetPresentAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid6"));
		headerMap2.put("X-Requested-With", prop.getProperty("XRequestedWith"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("Present"), headerMap2);
		
		//Status code Json String & Headers
	   TestUtil.staCodeJsonStringHeaders(httpResp);
	}	
	
	@Test(priority = 9)
	public void GetAbsentAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid6"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("Absent"), headerMap2);
		
	//Status code Json String & Headers
	JSONObject respJson = TestUtil.staCodeJsonStringHeaders(httpResp);
	
	String dateValue = TestUtil.getValueByJPath(respJson, "/record[0]/date");
	String durationValue = TestUtil.getValueByJPath(respJson, "/record[0]/duration");
	System.out.println("Value of type : "+dateValue);
	System.out.println("Value of date : "+durationValue);
	
	Assert.assertEquals(dateValue, "01-Jan-2020");
	Assert.assertEquals(durationValue, "00hrs 00mins");
	}
	@Test(priority = 10)
	public void GetHalfDayAPI() throws ClientProtocolException, IOException, JSONException {
		HashMap<String, String> headerMap2 = new HashMap<String, String>();
		headerMap2.put("auth-id", prop.getProperty("authid4"));
		headerMap2.putAll(header());
		httpResp=restClient.getResult(prop.getProperty("Halfday"), headerMap2);
		
	//Status code Json String & Headers
	TestUtil.staCodeJsonStringHeaders(httpResp);
	
	}
}
