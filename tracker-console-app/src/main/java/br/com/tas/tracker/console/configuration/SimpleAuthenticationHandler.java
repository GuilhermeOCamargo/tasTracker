package br.com.tas.tracker.console.configuration;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author guilherme.camargo
 * @since 16/10/2018
 * @version 1.0
 * */
@Component
public class SimpleAuthenticationHandler extends SimpleUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public SimpleAuthenticationHandler(){
		super();
		setUseReferer(true);
	}
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String email = auth.getName().toString().toLowerCase();
		session.setAttribute("loggedUser", email);
		String targetUrl = "/dashboard/list";
		/*Collection<GrantedAuthority> permissions = (Collection<GrantedAuthority>) auth.getAuthorities();
		String targetUrl = null;
		for (GrantedAuthority authPermission: permissions) {
			if(authPermission.getAuthority().equals("ROLE_EMPRESA")){
				targetUrl = "/questionario/pending";
			}else{
				targetUrl = "/empresa/list";
			}
		}*/
		redirectStrategy.sendRedirect(request, response, targetUrl);
		clearAuthenticationAttributes(request);
	}
	
//	protected void clearAuthenticationAttributes(HttpServletRequest request) {
//		HttpSession session = request.getSession(false);
//		if (session == null) return;
//
//		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//	}
}
