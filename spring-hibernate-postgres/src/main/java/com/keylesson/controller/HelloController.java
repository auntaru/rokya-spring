/*
   http://keylesson.com/index.php/2014/09/12/spring-mvc-hello-world-example-490/
   http://localhost:8080/spring-hibernate-postgres/hello.htm
   ||=> Hello World from HelloController !
   
   http://keylesson.com/index.php/java-ee/spring-mvc/
   
      http://www.programcreek.com/2014/02/spring-mvc-helloworld-using-maven-in-eclipse/
      http://localhost:8080/spring-hibernate-postgres/hello?name=Alex
      
      http://www.baeldung.com/spring-mvc-tutorial
      http://www.dineshonjava.com/2012/12/spring-30-mvc-hello-world-example.html

         http://www.gontu.org/spring-mvc-tutorials-05-creating-first-spring-mvc-web-application-using-eclipse-ide-01/
         http://www.gontu.org/wp-content/uploads/2014/08/creatingfirstwebappliaction.zip
         https://www.youtube.com/watch?v=bnB4x-oAd_M
         

*/

package com.keylesson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value = "/hello.htm", method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
		model.addAttribute("message", "Hello World from HelloController !");
		return "welcome";
	}

}
