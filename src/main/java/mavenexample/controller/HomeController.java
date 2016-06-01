package mavenexample.controller;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import mavenexample.Entities.Car;

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
		Car car = new Car("My Car");
		 ofy().save().entity(car).now();
		return "index";
	}
	
	/*@RequestMapping(value="/",method = RequestMethod.GET)
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		UserService userService = UserServiceFactory.getUserService();
		if(request.getUserPrincipal()==null){
			response.sendRedirect(userService.createLoginURL(getFullRequestUrl(request)));
		}else{
			response.sendRedirect("/index");
		}
		
	}*/
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		UserService userService = UserServiceFactory.getUserService();

		    //String thisUrl = request.getRequestURI();
             request.getSession().invalidate();
		    response.setContentType("text/html");
		    if (request.getUserPrincipal() != null) {
		    	response.sendRedirect(userService.createLogoutURL(this.getFullRequestUrl(request)));
		    } 
	}
	
	  private String getFullRequestUrl(HttpServletRequest req) {
		    String scheme = req.getScheme() + "://";
		    String serverName = req.getServerName();
		    String serverPort = (req.getServerPort() == 80) ? "" : ":" + req.getServerPort();
		    String contextPath = req.getContextPath();
		    String servletPath = req.getServletPath();
		    String pathInfo = (req.getPathInfo() == null) ? "" : req.getPathInfo();
		    //String queryString = (req.getQueryString() == null) ? "" : "?" + req.getQueryString();
		    return scheme + serverName + serverPort + contextPath + servletPath + pathInfo;
		  }
	
}
