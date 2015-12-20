package org.doc.donoroncall.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.doc.core.api.registration.handler.LoginHandler;
import org.doc.core.api.registration.handler.RegisterationHandler;
import org.doc.core.api.registration.info.LoginInfo;
import org.doc.core.api.registration.info.RegisterationInfo;
import org.doc.donoroncall.donar.DonorRequesterHandler;
import org.doc.donoroncall.donar.DonorRequesterInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
//import com.fasterxml.jackson.core.JsonGenerationException;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

@Controller
public class GatewayController {
	@Autowired
	private LoginHandler loginHand;
	@Autowired
	RegisterationHandler regHand;
	@Autowired
	DonorRequesterHandler drHandler;
	private static final String clz = "GatewayController: ";

	private final Logger logger = LoggerFactory.getLogger(GatewayController.class);

	public GatewayController() {
		
	}

	@RequestMapping(value = "doc/gateWay", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	String getOAuth(@RequestBody String inputAsJson) {
		logger.info(clz + "getOAuth GET start.");
		Gson gson=new Gson();
		LoginInfo loginInfo = gson.fromJson(inputAsJson, LoginInfo.class);
		String resString = loginHand.loginAuthenticate(loginInfo);
		Map<String, String> obj = new HashMap<String,String>();
		if(resString.equalsIgnoreCase("success")){		
		obj.put("success", "true");
		String uuid = UUID.randomUUID().toString()+loginInfo.getPassword();
		byte [] tokenByte = new Base64(true).encodeBase64(uuid.getBytes());
		String token = new String(tokenByte);
		obj.put("accessToken", token);		
		logger.info(clz + "getOAuth GET end."+loginInfo.getUserName()+"    "+resString);		
		}else{
			obj.put("success", "false");
			obj.put("accessToken", null);		
			logger.info(clz + "getOAuth GET end."+loginInfo.getUserName()+"    "+resString);
		}
		return gson.toJson(obj);
	}
	@RequestMapping(value = "doc/register", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	String register(@RequestBody String inputAsJson) {
		try{
		logger.info(GatewayController.class+"  Input String "+inputAsJson);	
		Gson gson=new Gson();
		RegisterationInfo regInfo = gson.fromJson(inputAsJson, RegisterationInfo.class);
		String resString = regHand.registerAccount(regInfo);		
		Map<String, String> obj = new HashMap<String,String>();
		if(resString.equalsIgnoreCase("success")){
		obj.put("registration", "success");
		obj.put("status", "pending");
		}else{
			obj.put("registration", "fail");
			obj.put("status", "unkwnon");
		}		
		return gson.toJson(obj);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value = "doc/donor", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody
	String donorRegister(@RequestBody String inputAsJson) {
		try{
		Gson gson=new Gson();
		DonorRequesterInfo drInfo = gson.fromJson(inputAsJson, DonorRequesterInfo.class);
		String resString = drHandler.donorRequest(drInfo);
		Map<String, String> obj = new HashMap<String,String>();
		if(resString.equalsIgnoreCase("success")){
		obj.put("registration", "success");
		obj.put("status", "pending");
		}else{
			obj.put("registration", "fail");
			obj.put("status", "unkwnon");
		}		
		return gson.toJson(obj);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
