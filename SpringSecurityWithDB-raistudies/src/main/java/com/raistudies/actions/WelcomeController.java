/*
 * <!-- http://www.raistudies.com/spring-security-tutorial/authentication-authorization-spring-security-mysql-database/ -->
 */

package com.raistudies.actions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public ModelAndView sayHello(Model model){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		model.addAttribute("HelloMessage", "Hello World from Spring Security application.");
		return mv;
	}
	
}

