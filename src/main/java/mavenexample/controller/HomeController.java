package mavenexample.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


@Controller
public class HomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String sendMessage(ModelMap model){
		model.addAttribute("message", "message");
		return "home";
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		UserService userService = UserServiceFactory.getUserService();

		    String thisUrl = request.getRequestURI();
        
		    response.setContentType("text/html");
		    if (request.getUserPrincipal() != null) {
		    	response.sendRedirect(userService.createLogoutURL(thisUrl));
		    } 
	}
}
