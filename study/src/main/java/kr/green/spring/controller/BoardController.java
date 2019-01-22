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
		 return "bbs/register"; //jsp瑜� �뿴�쑝�씪�뒗嫄�
	 }
	 
	 @RequestMapping(value="/bbs/register", method=RequestMethod.POST)
	 public String registerPost(BoardVo board) {
		 System.out.println(board);
		 boardService.register(board);
		 return "redirect:/bbs/list"; //redirect�뒗 URI�깉濡� �엯�젰�빐二쇰뒗嫄�. View媛� �븘�땲�씪 �떎�젣濡� �뿰寃�.
	 }
//3
}
