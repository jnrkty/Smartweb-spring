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
	private AccountService accountService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Locale locale, Model model) {
		
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String name){
		/* jsp�뿉�꽌 �꽆寃⑥� �뜲�씠�꽣瑜� 諛쏄린 �쐞�빐�꽌�뒗 �깭洹몄쓽 �냽�꽦 name怨� �씪移섑븯�뒗 �씠由꾩쓣 留ㅺ컻蹂��닔�쓽 �씠由꾩쑝濡� �꽕�젙�븳�떎
		 * 
		 * 
		 *  */
		System.out.println("jsp�뿉�꽌 �꽆�뼱�삩 媛� : " +name);
		return "redirect:/";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	//null媛믪쓣 �뿀�슜�빐二쇨린 �쐞�빐
	// int -> Integer, double -> Double, boolean -> Boolean
	public String signupGet(Boolean fail, Model model) {

		model.addAttribute("fail", fail);
		return "account/signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo, Model model) {
		if(accountService.signup(accountVo))
			return "redirect:/";
		else
			model.addAttribute("fail",true);
			return "redirect:/signup";
		
	}


}
