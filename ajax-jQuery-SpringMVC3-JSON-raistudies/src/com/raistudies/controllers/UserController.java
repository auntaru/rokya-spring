/*
 * http://www.raistudies.com/spring/spring-mvc/ajax-form-validation-using-spring-mvc-and-jquery/
 * http://www.raistudies.com/spring/spring-mvc/ajax-spring-mvc-3-annonations-jquery/
 * 
 * http://www.javacodegeeks.com/2012/02/spring-mvc-and-jquery-for-ajax-form.html
 * 
 * http://www.javacodegeeks.com/2013/05/spring-mvc-ajax-and-json-part-1-setting-the-scene.html
 *  http://www.captaindebug.com/2013/04/spring-mvc-ajax-and-json-part-1-setting.html
 * http://www.javacodegeeks.com/2013/05/spring-mvc-ajax-and-json-part-2-the-server-side-code.html
 *  http://www.captaindebug.com/2013/05/spring-mvc-ajax-and-json-part-2-server.html
 * http://www.javacodegeeks.com/2013/05/spring-mvc-ajax-and-json-part-3-the-client-side-code.html 
 *  http://www.captaindebug.com/2013/05/spring-mvc-ajax-and-json-part-3-client.html
 *  
 * https://github.com/roghughe/captaindebug/tree/master/ajax-json
 * 
 *  http://www.javacodegeeks.com/tag/ajax/
 *  
 *  http://it-ebooks.info/tag/spring/
 *  
 */
package com.raistudies.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.raistudies.domain.JsonResponse;
import com.raistudies.domain.User;

@Controller
public class UserController {
	private List<User> userList = new ArrayList<User>(); 
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.GET)
	public String showForm(){
		return "AddUser";
	}
	
	@RequestMapping(value="/AddUser.htm",method=RequestMethod.POST)
	public @ResponseBody JsonResponse addUser(@ModelAttribute(value="user") User user, BindingResult result ){
		JsonResponse res = new JsonResponse();
		ValidationUtils.rejectIfEmpty(result, "name", "Name can not be empty.");
		ValidationUtils.rejectIfEmpty(result, "education", "Educatioan not be empty");
		if(!result.hasErrors()){
			userList.add(user);
			res.setStatus("SUCCESS");
			res.setResult(userList);
		}else{
			res.setStatus("FAIL");
			res.setResult(result.getAllErrors());
		}
		
		return res;
	}

}
