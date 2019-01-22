package kr.green.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVo;

@Controller
//@RequestMapping(value="/bbs")
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	
	 @RequestMapping(value="/bbs/list")
	 public String list(Model model) {
		 List<BoardVo> boardList = boardService.getBoards();
		 model.addAttribute("list",boardList);
			return "bbs/list";
	 }
	 @RequestMapping(value="/bbs/register", method=RequestMethod.GET)
	 public String registerGet(BoardVo board) {
		 return "bbs/register"; //jsp�몴占� 占쎈였占쎌몵占쎌뵬占쎈뮉椰꾬옙
	 }
	 
	 @RequestMapping(value="/bbs/register", method=RequestMethod.POST)
	 public String registerPost(BoardVo board) {
		 System.out.println(board);
		 boardService.register(board);
		 return "redirect:/bbs/list"; //redirect占쎈뮉 URI占쎄퉱嚥∽옙 占쎌뿯占쎌젾占쎈퉸雅뚯눖�뮉椰꾬옙. View揶쏉옙 占쎈툡占쎈빍占쎌뵬 占쎈뼄占쎌젫嚥∽옙 占쎈염野껓옙.
	 }

}
