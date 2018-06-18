package by.htp.carparking.web.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String startPage() {
		return "error";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userPage() {
		return "user";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String accessDeniedPage() {
		
		return "error";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	@RequestMapping(value = "/startpage", method = RequestMethod.GET)
	public String startpage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println();
		Collection<? extends GrantedAuthority> col = auth.getAuthorities();
		for(GrantedAuthority ga : col) {
			System.out.println(ga.getAuthority());
		}
		 auth.getAuthorities();
		return "startpage";
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "login";
	}

}



