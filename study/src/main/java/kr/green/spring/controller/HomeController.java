package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model, Boolean signup) { //id에서 받은 데이터
		model.addAttribute("signup",signup);
		return "home";
	}
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signupGet(Model model, Boolean signup) {
		model.addAttribute("signup",signup);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.POST) //jsp에서 post로 보냈으니까 get으로 받을 수 없다
	public String signupPOST(AccountVo accountVo, Model model) { //편의상 post니까 signuppost로 알아보기 쉽게 메소드 지정해준거임
		if(accountService.signup(accountVo)){
			System.out.println("회원가입 성공");
			model.addAttribute("signup",true);
			return "redirect:/";
		}else {
			System.out.println("회원가입 실패");
			model.addAttribute("signup",false);
			return "redirect:/signup"; //redirect:/ -> post에선 보안이 꽁꽁이라 뿌려줄수없음. 그래서 get방식으로 보내는거. 처리다했으면 signup으로 다시가~
		}
		
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST) //jsp에서 post로 보냈으니까 get으로 받을 수 없다
	public String homePOST(String id, String pw, Model model) {
		 AccountVo user = accountService.login(id,pw);
		 if(user != null) {
				model.addAttribute("user",user);
				return "redirect:/bbs/list";
		 }
		 else {
		 return "redirect:/";
		 }
	}
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String login(AccountVo accountVo, Model model) {
//		if(accountService.login(accountVo)) {
//			System.out.println("로그인 성공");
//			model.addAttribute("login",true);
//			return "redirect:/";
//		}else {
//			System.out.println("로그인 실패");
//			model.addAttribute("login",false);
//			return "redirect:/";
//		}
//	}
	
}
