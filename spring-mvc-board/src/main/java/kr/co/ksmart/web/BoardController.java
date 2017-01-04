package kr.co.ksmart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ksmart.service.Board;
import kr.co.ksmart.service.BoardDao;
import kr.co.ksmart.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardList",method = RequestMethod.GET)
	public String boardList(){
		System.out.println("boardList 호출");
		return "/board/boardList";	//포워딩
	}
	
	@RequestMapping(value="/board/boardAdd",method = RequestMethod.GET)
	public String boardAdd(){
		System.out.println("boardAdd 호출");
		return "/board/boardAdd";	//포워딩
	}
	
	@RequestMapping(value="/board/boardAdd",method = RequestMethod.POST)
	public String boardAdd(Board board){
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}
}
