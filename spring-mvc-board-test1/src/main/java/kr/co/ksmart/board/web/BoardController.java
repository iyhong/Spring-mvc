package kr.co.ksmart.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ksmart.board.service.Board;
import kr.co.ksmart.board.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.GET)
	public String boardAdd(){
		System.out.println("BoardController.boardAdd()GET");
		return "/board/boardAdd";
	}
	@RequestMapping(value="/board/boardAdd", method=RequestMethod.POST)
	public String boardAdd(Board board){
		System.out.println("BoardController.boardAdd()POST");
		boardService.boardInsert(board);
		return "redirect:/board/boardList";
	}
	
}
