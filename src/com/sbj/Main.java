package com.sbj;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main {
	
	static Integer  groupId= 489;
	static Integer failureCount = 43;
	
	private static String curlCommand = "curl --location --request POST 'http://clm-pun-tuit38.bmc.com:8008/api/rx/application/command'\r\n" + 
			"--header 'Host:  clm-pun-tuit38.bmc.com:8008'\r\n" + 
			"--header 'Connection:  keep-alive'\r\n" + 
			"--header 'Content-Length:  194'\r\n" + 
			"--header 'Accept:  application/json, text/plain, */*'\r\n" + 
			"--header 'default-bundle-scope:  com.bmc.dsm.chatbot'\r\n" + 
			"--header 'request-overlay-group:  coke'\r\n" + 
			"--header 'X-Requested-By:  XMLHttpRequest'\r\n" + 
			"--header 'User-Agent:  Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36'\r\n" + 
			"--header 'Design-Time:  true'\r\n" + 
			"--header 'Content-Type:  application/json;charset=UTF-8'\r\n" + 
			"--header 'Origin:  http://clm-pun-tuit38.bmc.com:8008'\r\n" + 
			"--header 'Referer:  http://clm-pun-tuit38.bmc.com:8008/innovationstudio/index.html'\r\n" + 
			"--header 'Accept-Encoding:  gzip, deflate'\r\n" + 
			"--header 'Accept-Language:  en-US,en;q=0.9'\r\n" + 
			"--header 'Cookie:  AR-JWT=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWkxPR2NuUFE3amdGN09PVlNVd0xlZ2lublhkQ3R6TlhBUWJBRyt5aCIsIl9sb2NhbGVMYW5ndWFnZSI6ImVuIiwibmJmIjoxNTk4Njk3Nzg5LCJpc3MiOiJvbmJtYy1zIiwiX2xvY2FsZUNvdW50cnkiOiJVUyIsIl9hdXRoU3RyaW5nIjoiIT0he2VuY30hPSFBQUFBRExFaWllNzRkU3JXSUNsS1pQc29Nd3k2cjdyWDZwcW1TdzZvYUdFPSIsImV4cCI6MTU5ODcwMTUwOSwiX2NhY2hlSWQiOjI5MjUyLCJpYXQiOjE1OTg2OTc5MDksImp0aSI6IklER0FER0c4RUNEQzBBUTVUTVRVUTRWMzhTQ1FaMSIsIl9hYnNvbHV0ZUV4cGlyYXRpb25UaW1lIjoxNTk4NzgzODI2fQ.EMh8P6b8cwkKatzHMl_Mrj9_yefeywq4hWbNebpxDN0; _ga=GA1.2.1522827726.1578033886; sfbShellAppLaunched=yes; s_ecid=MCMID%7C65316162223778590581894274816305637403; legal.sacjadha.bmc.com=\"locale=en_US~country=US~company=BMC~govt=Y~expaccpt=Y~aid=78~tc=false\"; __qca=P0-1733848825-1578917480285; _hjid=1341767a-ad02-4dc2-a2c0-dcc005c0c973; clientchoice=DesktopClient; _psr=ps.2.5e858525b4a5415afd98cefd; mp_6c19213a15e865965d7bea68b7690529_mixpanel=%7B%22distinct_id%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22%24device_id%22%3A%20%2216fa49483107e-0244968395b334-c383f64-e1000-16fa49483119b3%22%2C%22Customer%20ID%22%3A%20%22BMC%20Software%20Inc.%22%2C%22%24user_id%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%2C%22User%20ID%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22Product%20ID%22%3A%20%22dwp%22%2C%22Product%20Version%22%3A%20%2219.08.00%22%2C%22Locale%22%3A%20%22en%22%2C%22Landing%20Page%22%3A%20%22Catalog%22%2C%22Catalog%20Enabled%22%3A%20true%2C%22Locations%20Enabled%22%3A%20true%2C%22My%20Stuff%20Enabled%22%3A%20true%2C%22Homepage%20Builder%20Enabled%22%3A%20false%2C%22Innovation%20Suite%20Application%20Enabled%22%3A%20false%7D; _gid=GA1.2.402197031.1598245340; ELOQUA=GUID=B8AE3D08965B437DB348340F25683E8A; mbox=PC#11e151f49f2a488a897c9fcea7456708.35_0#1661768715|session#39d32ae227944479bd317142eee1c311#1598525775; __utma=246752535.1522827726.1578033886.1598517040.1598523916.10; __utmz=246752535.1598523916.10.8.utmcsr=bmc.okta.com|utmccn=(referral)|utmcmd=referral|utmcct=/app/template_saml_2_0/exk17ow1q3gkVAYtP1d8/sso/saml; s_pers=%20cvp_v8%3D%255B%255B%2527pdfBMC%25252520Chatbot_180%2527%252C%25271586525414680%2527%255D%255D%7C1744291814680%3B%20gpv_pn%3Ddocs%7C1598685519389%3B%20gpv_p11%3Ddocs.bmc.com%253Adocs%253Ahelixplatform%253Acreating-process-steps-or-activities-851870316%7C1598685557263%3B; s_sess=%20orgTime%3D1598683719%3B%20s_vi_decimal%3D7291716345798294000-6347986571212763000%3B%20s_cc%3Dtrue%3B%20s_sq%3Dbmcsoftwarecomprod%253D%252526c.%252526a.%252526activitymap.%252526page%25253Ddocs.bmc.com%2525253Adocs%2525253Ahelixplatform%2525253Acreating-process-steps-or-activities-851870316%252526link%25253DTo%25252520enable%25252520multi%25252520instance%25252520loop%252526region%25253DBODY%252526pageIDType%25253D1%252526.activitymap%252526.a%252526.c%252526pid%25253Ddocs.bmc.com%2525253Adocs%2525253Ahelixplatform%2525253Acreating-process-steps-or-activities-851870316%252526pidt%25253D1%252526oid%25253Dhttps%2525253A%2525252F%2525252Fdocs.bmc.com%2525252Fdocs%2525252Fhelixplatform%2525252Fcreating-process-steps-or-activities-851870316.html%25252523Creating%252526ot%25253DA%3B; AR-JWT=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWkxPR2NuUFE3amdGN09PVlNVd0xlZ2lublhkQ3R6TlhBUWJBRyt5aCIsIl9sb2NhbGVMYW5ndWFnZSI6ImVuIiwibmJmIjoxNTk4Njk4MTYzLCJpc3MiOiJvbmJtYy1zIiwiX2xvY2FsZUNvdW50cnkiOiJVUyIsIl9hdXRoU3RyaW5nIjoiIT0he2VuY30hPSFBQUFBRExFaWllNzRkU3JXSUNsS1pQc29Nd3k2cjdyWDZwcW1TdzZvYUdFPSIsImV4cCI6MTU5ODcwMTg4MywiX2NhY2hlSWQiOjI5MjUyLCJpYXQiOjE1OTg2OTgyODMsImp0aSI6IklER0FER0c4RUNEQzBBUTVUTVRVUTRWMzhTQ1FaMSIsIl9hYnNvbHV0ZUV4cGlyYXRpb25UaW1lIjoxNTk4NzgzODI2fQ.U_uaSVzV6YQDmPKUtCF5eN1Si0Qo_A36lk7_4s-XW7M'\r\n" + 
			"--data-raw '{\"resourceType\":\"com.bmc.arsys.rx.application.process.command.StartProcessInstanceCommand\",\"processDefinitionName\":\"com.bmc.dsm.chatbot:Create Group\",\"processInputValues\":{\"input group id\":\""+groupId+"\"}}'";
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		 * for(int i = 489;i< 349000;i++) { executeCurl(); }
		 */
		String singleJSOnObject ="{" + 
				"\"groupByValues\": [\"AGGADGG8ECDC0AP0PA6EPJSIGS75QX\", \"chatbot-ui\", \"IDGADGG8ECDC0AQ6AOB0Q5C4J19LGL\"]," + 
				"\"freqInterval\": \"2020-9-2\"," + 
				"\"appId\": \"com.bmc.dsm.chatbot\"," + 
				"\"count\": 2," + 
				"\"operationResults\": {}" + 
				"},";
		String finalObject="";
		File file = new File("test.txt");
		PrintWriter pw = new PrintWriter(file);
		for(int i=0;i < 3661;i++) {
			//finalObject+=singleJSOnObject;
			//System.out.print(singleJSOnObject);
			
			pw.append(singleJSOnObject);
			System.out.println(i);
		}
		pw.close();
		
		List<String> str = new ArrayList<String>();
		str.add("Abcd");
		str.add("lmn");
		str.add("xyz");
		
		for(String sr : str) {
			System.out.println(sr);
			str.add("NEW");
		}
	}
	
	private static void executeCurl() throws IOException, InterruptedException {
        if(groupId == 60000) {
            groupId = 61000;
        }
		/*OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse(" application/json;charset=UTF-8");
				RequestBody body = RequestBody.create(mediaType, "{\"resourceType\":\"com.bmc.arsys.rx.application.process.command.StartProcessInstanceCommand\",\"processDefinitionName\":\"com.bmc.dsm.chatbot:Create Group\",\"processInputValues\":{\"input group id\":\""+groupId+"\"}}");
				Request request = new Request.Builder()
				  .url("http://clm-pun-tuit38.bmc.com:8008/api/rx/application/command")
				  .method("POST", body)
				  .addHeader("Host", " clm-pun-tuit38.bmc.com:8008")
				  .addHeader("Connection", " keep-alive")
				  .addHeader("Content-Length", " 194")*/
				  //.addHeader("Accept", " application/json, text/plain, */*")
		/*
		 * .addHeader("default-bundle-scope", " com.bmc.dsm.chatbot")
		 * .addHeader("request-overlay-group", " coke") .addHeader("X-Requested-By",
		 * " XMLHttpRequest") .addHeader("User-Agent",
		 * " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36"
		 * ) .addHeader("Design-Time", " true") .addHeader("Content-Type",
		 * " application/json;charset=UTF-8") .addHeader("Origin",
		 * " http://clm-pun-tuit38.bmc.com:8008") .addHeader("Referer",
		 * " http://clm-pun-tuit38.bmc.com:8008/innovationstudio/index.html")
		 * .addHeader("Accept-Encoding", " gzip, deflate") .addHeader("Accept-Language",
		 * " en-US,en;q=0.9") .addHeader("Cookie",
		 * " AR-JWT=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWkxPR2NuUFE3amdGN09PVlNVd0xlZ2lublhkQ3R6TlhBUWJBRyt5aCIsIl9sb2NhbGVMYW5ndWFnZSI6ImVuIiwibmJmIjoxNTk4Njk3Nzg5LCJpc3MiOiJvbmJtYy1zIiwiX2xvY2FsZUNvdW50cnkiOiJVUyIsIl9hdXRoU3RyaW5nIjoiIT0he2VuY30hPSFBQUFBRExFaWllNzRkU3JXSUNsS1pQc29Nd3k2cjdyWDZwcW1TdzZvYUdFPSIsImV4cCI6MTU5ODcwMTUwOSwiX2NhY2hlSWQiOjI5MjUyLCJpYXQiOjE1OTg2OTc5MDksImp0aSI6IklER0FER0c4RUNEQzBBUTVUTVRVUTRWMzhTQ1FaMSIsIl9hYnNvbHV0ZUV4cGlyYXRpb25UaW1lIjoxNTk4NzgzODI2fQ.EMh8P6b8cwkKatzHMl_Mrj9_yefeywq4hWbNebpxDN0; _ga=GA1.2.1522827726.1578033886; sfbShellAppLaunched=yes; s_ecid=MCMID%7C65316162223778590581894274816305637403; legal.sacjadha.bmc.com=\"locale=en_US~country=US~company=BMC~govt=Y~expaccpt=Y~aid=78~tc=false\"; __qca=P0-1733848825-1578917480285; _hjid=1341767a-ad02-4dc2-a2c0-dcc005c0c973; clientchoice=DesktopClient; _psr=ps.2.5e858525b4a5415afd98cefd; mp_6c19213a15e865965d7bea68b7690529_mixpanel=%7B%22distinct_id%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22%24device_id%22%3A%20%2216fa49483107e-0244968395b334-c383f64-e1000-16fa49483119b3%22%2C%22Customer%20ID%22%3A%20%22BMC%20Software%20Inc.%22%2C%22%24user_id%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%2C%22User%20ID%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22Product%20ID%22%3A%20%22dwp%22%2C%22Product%20Version%22%3A%20%2219.08.00%22%2C%22Locale%22%3A%20%22en%22%2C%22Landing%20Page%22%3A%20%22Catalog%22%2C%22Catalog%20Enabled%22%3A%20true%2C%22Locations%20Enabled%22%3A%20true%2C%22My%20Stuff%20Enabled%22%3A%20true%2C%22Homepage%20Builder%20Enabled%22%3A%20false%2C%22Innovation%20Suite%20Application%20Enabled%22%3A%20false%7D; _gid=GA1.2.402197031.1598245340; ELOQUA=GUID=B8AE3D08965B437DB348340F25683E8A; mbox=PC#11e151f49f2a488a897c9fcea7456708.35_0#1661768715|session#39d32ae227944479bd317142eee1c311#1598525775; __utma=246752535.1522827726.1578033886.1598517040.1598523916.10; __utmz=246752535.1598523916.10.8.utmcsr=bmc.okta.com|utmccn=(referral)|utmcmd=referral|utmcct=/app/template_saml_2_0/exk17ow1q3gkVAYtP1d8/sso/saml; s_pers=%20cvp_v8%3D%255B%255B%2527pdfBMC%25252520Chatbot_180%2527%252C%25271586525414680%2527%255D%255D%7C1744291814680%3B%20gpv_pn%3Ddocs%7C1598685519389%3B%20gpv_p11%3Ddocs.bmc.com%253Adocs%253Ahelixplatform%253Acreating-process-steps-or-activities-851870316%7C1598685557263%3B; s_sess=%20orgTime%3D1598683719%3B%20s_vi_decimal%3D7291716345798294000-6347986571212763000%3B%20s_cc%3Dtrue%3B%20s_sq%3Dbmcsoftwarecomprod%253D%252526c.%252526a.%252526activitymap.%252526page%25253Ddocs.bmc.com%2525253Adocs%2525253Ahelixplatform%2525253Acreating-process-steps-or-activities-851870316%252526link%25253DTo%25252520enable%25252520multi%25252520instance%25252520loop%252526region%25253DBODY%252526pageIDType%25253D1%252526.activitymap%252526.a%252526.c%252526pid%25253Ddocs.bmc.com%2525253Adocs%2525253Ahelixplatform%2525253Acreating-process-steps-or-activities-851870316%252526pidt%25253D1%252526oid%25253Dhttps%2525253A%2525252F%2525252Fdocs.bmc.com%2525252Fdocs%2525252Fhelixplatform%2525252Fcreating-process-steps-or-activities-851870316.html%25252523Creating%252526ot%25253DA%3B; AR-JWT=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWkxPR2NuUFE3amdGN09PVlNVd0xlZ2lublhkQ3R6TlhBUWJBRyt5aCIsIl9sb2NhbGVMYW5ndWFnZSI6ImVuIiwibmJmIjoxNTk4Njk4MTYzLCJpc3MiOiJvbmJtYy1zIiwiX2xvY2FsZUNvdW50cnkiOiJVUyIsIl9hdXRoU3RyaW5nIjoiIT0he2VuY30hPSFBQUFBRExFaWllNzRkU3JXSUNsS1pQc29Nd3k2cjdyWDZwcW1TdzZvYUdFPSIsImV4cCI6MTU5ODcwMTg4MywiX2NhY2hlSWQiOjI5MjUyLCJpYXQiOjE1OTg2OTgyODMsImp0aSI6IklER0FER0c4RUNEQzBBUTVUTVRVUTRWMzhTQ1FaMSIsIl9hYnNvbHV0ZUV4cGlyYXRpb25UaW1lIjoxNTk4NzgzODI2fQ.U_uaSVzV6YQDmPKUtCF5eN1Si0Qo_A36lk7_4s-XW7M"
		 * ) .build();
		 */
				
        OkHttpClient client = new OkHttpClient().newBuilder()
        		  .build();
        		MediaType mediaType = MediaType.parse(" application/json;charset=UTF-8");
        		RequestBody body = RequestBody.create(mediaType, "{\"resourceType\":\"com.bmc.arsys.rx.application.process.command.StartProcessInstanceCommand\",\"processDefinitionName\":\"com.bmc.dsm.chatbot:Create Group\",\"processInputValues\":{\"input group id\":\""+groupId+"\"}}");
        		Request request = new Request.Builder()
        		  .url("http://clm-pun-tuit38.bmc.com:8008/api/rx/application/command")
        		  .method("POST", body)
        		  .addHeader("Host", " clm-pun-tuit38.bmc.com:8008")
        		  .addHeader("Connection", " keep-alive")
        		  .addHeader("Content-Length", " 195")
        		  .addHeader("Accept", " application/json, text/plain, */*")
        		  .addHeader("default-bundle-scope", " com.bmc.dsm.chatbot")
        		  .addHeader("request-overlay-group", " pepsi")
        		  .addHeader("X-Requested-By", " XMLHttpRequest")
        		  .addHeader("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36")
        		  .addHeader("Design-Time", " true")
        		  .addHeader("Content-Type", " application/json;charset=UTF-8")
        		  .addHeader("Origin", " http://clm-pun-tuit38.bmc.com:8008")
        		  .addHeader("Referer", " http://clm-pun-tuit38.bmc.com:8008/innovationstudio/index.html")
        		  .addHeader("Accept-Encoding", " gzip, deflate")
        		  .addHeader("Accept-Language", " en-US,en;q=0.9")
        		  .addHeader("Cookie", " AR-JWT=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWktDTWFXWDV6U2NMK2I2ZkNFSXlMZW1LejFtYUNYYTZUajhcL3hWMkZHelk9IiwiX2xvY2FsZUxhbmd1YWdlIjoiZW4iLCJuYmYiOjE1OTg3MTQ2NTMsImlzcyI6Im9uYm1jLXMiLCJfbG9jYWxlQ291bnRyeSI6IlVTIiwiX2F1dGhTdHJpbmciOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWlBzb013eTZyN3JYNnBxbVN3Nm9hR0U9IiwiZXhwIjoxNTk4NzE4MzczLCJfY2FjaGVJZCI6MzExOTgsImlhdCI6MTU5ODcxNDc3MywianRpIjoiSURHQURHRzhFQ0RDMEFRNVVBR1lRNFZRVldFMU5KIiwiX2Fic29sdXRlRXhwaXJhdGlvblRpbWUiOjE1OTg4MDExNDZ9.6eJ7B3f29Wmu7zpVEeSbsiuXQD_Z4apxqY3SdG-qjGc; _ga=GA1.2.1522827726.1578033886; sfbShellAppLaunched=yes; s_ecid=MCMID%7C65316162223778590581894274816305637403; legal.sacjadha.bmc.com=\"locale=en_US~country=US~company=BMC~govt=Y~expaccpt=Y~aid=78~tc=false\"; __qca=P0-1733848825-1578917480285; _hjid=1341767a-ad02-4dc2-a2c0-dcc005c0c973; clientchoice=DesktopClient; _psr=ps.2.5e858525b4a5415afd98cefd; mp_6c19213a15e865965d7bea68b7690529_mixpanel=%7B%22distinct_id%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22%24device_id%22%3A%20%2216fa49483107e-0244968395b334-c383f64-e1000-16fa49483119b3%22%2C%22Customer%20ID%22%3A%20%22BMC%20Software%20Inc.%22%2C%22%24user_id%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22%24initial_referrer%22%3A%20%22%24direct%22%2C%22%24initial_referring_domain%22%3A%20%22%24direct%22%2C%22User%20ID%22%3A%20%22e411c06c-4872-3a9e-9c5b-2001be1dc4fe%22%2C%22Product%20ID%22%3A%20%22dwp%22%2C%22Product%20Version%22%3A%20%2219.08.00%22%2C%22Locale%22%3A%20%22en%22%2C%22Landing%20Page%22%3A%20%22Catalog%22%2C%22Catalog%20Enabled%22%3A%20true%2C%22Locations%20Enabled%22%3A%20true%2C%22My%20Stuff%20Enabled%22%3A%20true%2C%22Homepage%20Builder%20Enabled%22%3A%20false%2C%22Innovation%20Suite%20Application%20Enabled%22%3A%20false%7D; _gid=GA1.2.402197031.1598245340; ELOQUA=GUID=B8AE3D08965B437DB348340F25683E8A; mbox=PC#11e151f49f2a488a897c9fcea7456708.35_0#1661768715|session#39d32ae227944479bd317142eee1c311#1598525775; __utma=246752535.1522827726.1578033886.1598517040.1598523916.10; __utmz=246752535.1598523916.10.8.utmcsr=bmc.okta.com|utmccn=(referral)|utmcmd=referral|utmcct=/app/template_saml_2_0/exk17ow1q3gkVAYtP1d8/sso/saml; s_pers=%20cvp_v8%3D%255B%255B%2527pdfBMC%25252520Chatbot_180%2527%252C%25271586525414680%2527%255D%255D%7C1744291814680%3B%20gpv_pn%3Ddocs%7C1598702683892%3B%20gpv_p11%3Ddocs.bmc.com%253Adocs%253Ahelixplatform%253Aupdating-centralized-tenant-configuration-settings-851871154%7C1598702683958%3B; s_sess=%20s_sq%3D%3B%20orgTime%3D1598700884%3B%20s_vi_decimal%3D7291716345798294000-6347986571212763000%3B%20s_cc%3Dtrue%3B; AR-JWT=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWktDTWFXWDV6U2NMK2I2ZkNFSXlMZW1LejFtYUNYYTZUajhcL3hWMkZHelk9IiwiX2xvY2FsZUxhbmd1YWdlIjoiZW4iLCJuYmYiOjE1OTg3MTQ3NTIsImlzcyI6Im9uYm1jLXMiLCJfbG9jYWxlQ291bnRyeSI6IlVTIiwiX2F1dGhTdHJpbmciOiIhPSF7ZW5jfSE9IUFBQUFETEVpaWU3NGRTcldJQ2xLWlBzb013eTZyN3JYNnBxbVN3Nm9hR0U9IiwiZXhwIjoxNTk4NzE4NDcyLCJfY2FjaGVJZCI6MzExOTgsImlhdCI6MTU5ODcxNDg3MiwianRpIjoiSURHQURHRzhFQ0RDMEFRNVVBR1lRNFZRVldFMU5KIiwiX2Fic29sdXRlRXhwaXJhdGlvblRpbWUiOjE1OTg4MDExNDZ9.iY7n_uqYSTYCbHgcVrJ2sni_1cDh8GlEPdOIe_XgL_k")
        		  .build();
        		Response response = client.newCall(request).execute();
				if(response!=null && response.code()!= 201) {
					failureCount++;
					System.out.println("Error response:"+response.code() +"::"+response.message());
					System.out.println("Failed for groupid:"+groupId+", Failure count"+failureCount);
				}else {
					System.out.println("Created for :"+groupId);
				}
				response.body().close();
				groupId++;
				
				Thread.sleep(500);
				
	}
}
