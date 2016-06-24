package filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SessionFilter implements Filter {
	
	
	private FilterConfig filterConfig = null;
	
	private static final String REDIRECT = "redirect";
	private static final String SESSIONNAME = "sessionName";

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String sessionName = filterConfig.getInitParameter(SESSIONNAME);
		
		Object obj = req.getSession().getAttribute(sessionName);
		if(obj != null){
			chain.doFilter(request, response);
		}else{
			String redirect = filterConfig.getInitParameter(REDIRECT);
			res.sendRedirect(redirect);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig;
	}

	
	

}
