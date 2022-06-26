package com.sbj;

public class JsonReplication {

	public static void main(String[] args) {
		String singleJSOnObject ="{" + 
				"\"groupByValues\": [\"AGGADGG8ECDC0AP0PA6EPJSIGS75QX\", \"chatbot-ui\", \"IDGADGG8ECDC0AQ6AOB0Q5C4J19LGL\"]," + 
				"\"freqInterval\": \"2020-9-2\"," + 
				"\"appId\": \"com.bmc.dsm.chatbot\"," + 
				"\"count\": 2," + 
				"\"operationResults\": {}" + 
				"},";
		String finalObject="";
		for(int i=0;i < 50;i++) {
			//finalObject+=singleJSOnObject;
			System.out.print(singleJSOnObject);
		}
		//System.out.println("Final:"+finalObject);
	}

}
