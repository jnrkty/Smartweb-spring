package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UnauthInterceptor  extends HandlerInterceptorAdapter {
	 
		@Override
		public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
//			HttpSession session = request.getSession();
//			Object user = session.getAttribute("user");
			Object user = request.getSession().getAttribute("user");
			if(user != null) { //로그인이 되어있으면 게시판 페이지로 보내라
				response.sendRedirect(request.getContextPath()+"/bbs/list");
			}
			return true;
		}
	}

