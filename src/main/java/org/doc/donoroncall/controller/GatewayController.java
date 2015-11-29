package org.doc.donoroncall.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

@Controller
public class GatewayController {

	private static final String clz = "GatewayController: ";

	private final Logger logger = LoggerFactory.getLogger(GatewayController.class);

	public GatewayController() {
		//super();
	}

	@RequestMapping(value = "donoroncall/gateWay", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	String getOAuth() {
		logger.info(clz + "getOAuth GET start.");

		//System.out.println("Login to start..................");

		logger.info(clz + "getOAuth GET end.");

		return null;
	}

}
