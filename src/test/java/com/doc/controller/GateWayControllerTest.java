/**
 * 
 */
package com.doc.controller;

import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.junit.Test;

/**
 * @author pandiyaraja
 * 
 */
public class GateWayControllerTest {
	@Test
	public void loginTest() {

		RestClient rc = new RestClient();

		StringBuilder strb = new StringBuilder();
		strb.append("{\"userName\":\"Pandi\",\"password\":\"Pan\"}");
		Resource resource = rc
				.resource("http://localhost:8080/donoroncall/doc/gateWay");
		String response = resource.contentType("application/json")
				.accept("application/json").post(String.class, strb.toString());
		System.out.println(response);
	}
}
