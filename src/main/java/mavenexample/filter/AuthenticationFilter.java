package mavenexample.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class AuthenticationFilter implements Filter {

	private FilterConfig filterConfig;
	private String param;
	private String[] skipResources=null ;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		boolean requestOk = true;
        System.out.println("In filter");
		UserService userService = UserServiceFactory.getUserService();
        
		if(request instanceof HttpServletRequest){
				HttpServletRequest req = (HttpServletRequest) request;
			    HttpServletResponse res = (HttpServletResponse) response;
		    String thisUrl = req.getRequestURI();
	        System.out.println("in if");
		    response.setContentType("text/html");
		    System.out.println("this url"+thisUrl);
		    System.out.println("skip resources"+skipResources);
		    if(skipResources!=null && StringUtils.indexOfAny(thisUrl, skipResources) < 0){
		    	 System.out.println("incskipcresources");
		    	 if (req.getUserPrincipal() != null) {
		    		 System.out.println("user is not  null");
				    	chain.doFilter(request, response);
				    } else {
				    	System.out.println("user is null");
				    	res.sendRedirect("/login");
				    }
		    }else{
		    	chain.doFilter(request, response);
		    }
		   
		}else{
			chain.doFilter(request, response);
		}
		
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
		//can access filter's init param
		skipResources = StringUtils.split(filterConfig.getInitParameter("skipResources"), ",");
		/*String skipResourceString = null;
		skipResourceString = config.getInitParameter("skipResources");
		System.out.println("skipResourceString>>>"+skipResourceString);
		if(skipResourceString!=null){
			skipResources = skipResourceString.split(",");
		}*/
		
	}

	  private static String getFullRequestUrl(HttpServletRequest req) {
		   String scheme = req.getScheme() + "://";
		   String serverName = req.getServerName();
		   String serverPort = (req.getServerPort() == 80) ? "" : ":" + req.getServerPort();
		   String contextPath = req.getContextPath();
		   /*String servletPath = req.getServletPath();
		   String pathInfo = (req.getPathInfo() == null) ? "" : req.getPathInfo();*/
		   //String queryString = (req.getQueryString() == null) ? "" : "?" + req.getQueryString();
		   return scheme + serverName + serverPort + contextPath;
		 }
}
