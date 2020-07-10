package com.qa.util;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	public static JSONObject responseJson;
	
	public static String getValueByJPath(JSONObject responsejson, String jpath) throws JSONException{
		Object obj = responsejson;
		for(String s : jpath.split("/")) 
			if(!s.isEmpty()) 
				if(!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if(s.contains("[") || s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		return obj.toString();
	}
	
	//Status Code
	public static void statusCode(CloseableHttpResponse httpResp) {
		int staCode = httpResp.getStatusLine().getStatusCode();		
		System.out.println("Status code is : "+staCode );
		Assert.assertEquals(staCode, RESPONSE_STATUS_CODE_200	,"Status code is not 200");
	}
	
	//Json String
	public static JSONObject JsonString(CloseableHttpResponse httpResp) throws ParseException, IOException, JSONException {
		String respString = EntityUtils.toString(httpResp.getEntity(),"UTF-8");	
		JSONObject respJson = new JSONObject(respString);
		System.out.println("JSON Response From API : "+ respJson);
		return respJson;
	}
	
	//All Header
	public static void allHeaders(CloseableHttpResponse httpResp) {
		Header[] allArray = httpResp.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		for (Header header : allArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("Headers Array : "+ allHeaders);
		}
	}

