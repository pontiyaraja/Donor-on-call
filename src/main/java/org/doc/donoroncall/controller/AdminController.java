/**
 * 
 */
package org.doc.donoroncall.controller;

import java.util.HashMap;
import java.util.Map;

import org.doc.donoroncall.admin.AdminHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

/**
 * @author pandiyaraja
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminHandler adminHandler;
	@RequestMapping(value = "/regUserList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String listAllRegisteredUsers(){
		return adminHandler.getRegUserList();
	}
	
	@RequestMapping(value = "/authorize", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String authorizeUser(@RequestParam String userName){
		Gson gson=new Gson();
		String resString =  adminHandler.authorizeUser(userName);
		Map<String, String> obj = new HashMap<String,String>();
		if(resString.equalsIgnoreCase("success")){
		obj.put("authorization", "yes");
		obj.put("status", "success");
		}else{
			obj.put("authorization", "unknown");
			obj.put("status", "failed");
		}		
		return gson.toJson(obj);
	}
	
	@RequestMapping(value = "/acceptBloodRequest", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String acceptBloodRequest(@RequestParam String userName){
		Gson gson=new Gson();
		String resString = adminHandler.acceptBloodRequest(userName);
		Map<String, String> obj = new HashMap<String,String>();
		if(resString.equalsIgnoreCase("success")){
		obj.put("blood_request", "accepted");
		obj.put("status", "success");
		}else{
			obj.put("blood_request", "unknown");
			obj.put("status", "failed");
		}		
		return gson.toJson(obj);
	}
}
