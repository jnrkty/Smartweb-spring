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
	public String home( Model model, Boolean signup) { //id�뿉�꽌 諛쏆� �뜲�씠�꽣
		model.addAttribute("signup",signup);
		return "home";
	}
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signupGet(Model model, Boolean signup) {
		model.addAttribute("signup",signup);
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.POST) //jsp�뿉�꽌 post濡� 蹂대깉�쑝�땲源� get�쑝濡� 諛쏆쓣 �닔 �뾾�떎
	public String signupPOST(AccountVo accountVo, Model model) { //�렪�쓽�긽 post�땲源� signuppost濡� �븣�븘蹂닿린 �돺寃� 硫붿냼�뱶 吏��젙�빐以�嫄곗엫
		if(accountService.signup(accountVo)){
			System.out.println("�쉶�썝媛��엯 �꽦怨�");
			model.addAttribute("signup",true);
			return "redirect:/";
		}else {
			System.out.println("�쉶�썝媛��엯 �떎�뙣");
			model.addAttribute("signup",false);
			return "redirect:/signup"; //redirect:/ -> post�뿉�꽑 蹂댁븞�씠 苑곴퐗�씠�씪 肉뚮젮以꾩닔�뾾�쓬. 洹몃옒�꽌 get諛⑹떇�쑝濡� 蹂대궡�뒗嫄�. 泥섎━�떎�뻽�쑝硫� signup�쑝濡� �떎�떆媛�~
		}
		
	}
	
	@RequestMapping(value = "/", method=RequestMethod.POST) //jsp�뿉�꽌 post濡� 蹂대깉�쑝�땲源� get�쑝濡� 諛쏆쓣 �닔 �뾾�떎
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
//			System.out.println("濡쒓렇�씤 �꽦怨�");
//			model.addAttribute("login",true);
//			return "redirect:/";
//		}else {
//			System.out.println("濡쒓렇�씤 �떎�뙣");
//			model.addAttribute("login",false);
//			return "redirect:/";
//		}
//	}
	
}
