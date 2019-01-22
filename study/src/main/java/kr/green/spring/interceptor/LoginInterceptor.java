package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;

public class LoginInterceptor 
	 extends HandlerInterceptorAdapter{
	 @Override
	 public void postHandle(
	     HttpServletRequest request, 
	     HttpServletResponse response, 
	     Object handler, 
	     ModelAndView modelAndView)
	     throws Exception {
//	     ModelMap modelMap = modelAndView.getModelMap();
//	     AccountVo user = (AccountVo)modelMap.get("user");
	     AccountVo user = (AccountVo)(modelAndView.getModelMap().get("user")); //modelAndView -> 받아오는거
	     if(user != null) {
//	         HttpSession session = request.getSession();
//	         session.setAttribute("user", user);
	    		
	         request.getSession().setAttribute("user", user);
	     }
	 }
	}


