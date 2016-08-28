package com.practo.movies.cms.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPUtil {
	
	private static final Logger logger = LogManager.getLogger(HTTPUtil.class);
	
	public static JSONObject httpGET(String url) {
		
		CloseableHttpClient client = getPooledHttpClient();
		HttpUriRequest request = new HttpGet(url);
		JSONObject json = new JSONObject();
        try {
            CloseableHttpResponse response = client.execute(request);
            try {
                HttpEntity entity = response.getEntity();                
                json.put("code", response.getStatusLine().getStatusCode());
            	ByteArrayOutputStream os = new ByteArrayOutputStream();
            	String contentString = null;
            	try {
            		entity.writeTo(os);
            		contentString = new String(os.toByteArray());
            	} catch (IOException ex) {
            		logger.error("HTTP GET failed for URL: " + url + " Exception: " + ex.getMessage());
            		return json;
            	}            	
            	try{
            		json.put("content", new JSONObject(contentString));
            	} catch(JSONException e){
            		logger.error("URL: " + url + " cannot JSONify response. Error: " + e.getMessage());          		
            	}                
            } finally {
                response.close();
            }
        } catch (ClientProtocolException ex) {
        	logger.error("HTTP GET failed for URL: " + url + " Exception: " + ex.getMessage());
        } catch (IOException ex) {
        	logger.error("HTTP GET failed for URL: " + url + " Exception: " + ex.getMessage());
        } catch (Exception ex) {
        	logger.error("HTTP GET failed for URL: " + url + " Exception: " + ex.getMessage());
        }
		return json;
	}
	
	public static CloseableHttpClient getPooledHttpClient() {
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		// Increase max total connection to 200
		cm.setMaxTotal(50);
		// Increase default max connection per route to 20
		cm.setDefaultMaxPerRoute(5);
		
		RequestConfig config = RequestConfig.custom()
				  .setConnectTimeout(100 * 1000)
				  .setConnectionRequestTimeout(100 * 1000)
				  .setSocketTimeout(100 * 1000).build();		

		CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config)
		        .setConnectionManager(cm)
		        .build();	
		
		return httpClient;
		
	}

	public static void validate(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}

	public static Map<String, Object> httpPOST(Map<String, Object> query) {
		// TODO Auto-generated method stub
		return null;
	}	

}
