package kr.co.ksmart.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ksmart.service.Board;
import kr.co.ksmart.service.BoardService;


@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/boardList",method = RequestMethod.GET)
	//Model 은 Map을 상속받아 만든 객체 DispatcherServlet 에서 만들어짐
	public String boardList(Model model,
			//String형으로 무조건받아지는데 자동으로 int로 형변환, 안넘어오면 1로 초기화
			@RequestParam(value="currentPage", defaultValue="1") int currentPage){
		System.out.println("boardList 호출");
		System.out.println("currentPage:"+currentPage);
		//결과를 Map에 담는다
		Map<String, Object> returnMap = boardService.getBoardListPerCurrentPage(currentPage);
		//Map의 내용을 request에 담지못하니까 spring에서 지원하는 Model에 담는다
		model.addAttribute("totalRowCount", returnMap.get("totalRowCount"));
		model.addAttribute("lastPage", returnMap.get("lastPage"));
		model.addAttribute("list", returnMap.get("list"));
		model.addAttribute("currentPage", currentPage);
		return "board/boardList";	//포워딩
	}
	
	@RequestMapping(value="/board/boardAdd",method = RequestMethod.GET)
	public String boardAdd(){
		System.out.println("boardAdd GET 호출");
		return "/board/boardAdd";	//포워딩
	}
	
	@RequestMapping(value="/board/boardAdd",method = RequestMethod.POST)
	public String boardAdd(Board board){
		System.out.println("boardAdd POST 호출");
		System.out.println(board);
		boardService.addBoard(board);
		return "redirect:/board/boardList";
	}
	@RequestMapping(value="/board/boardView")
	public String boardView(Model model, Board board){
		System.out.println("boardView 호출");
		System.out.println("board:"+board);
		Board returnBoard = boardService.getBoard(board);
		System.out.println("returnBoard:"+returnBoard);
		model.addAttribute("board",returnBoard);
		return "/board/boardView";
	}
	@RequestMapping(value="/board/boardModify", method = RequestMethod.GET)
	public String boardUpdate(Model model, Board board){
		System.out.println("boardModify GET 호출");
		Board returnBoard = boardService.getBoard(board);
		model.addAttribute("board",returnBoard);
		return "/board/boardModify";
	}
	
	@RequestMapping(value="/board/boardModify", method = RequestMethod.POST)
	public String boardUpdateAction(Model model, Board board){
		System.out.println("boardModify POST 호출");
		int result = boardService.modifyBoard(board);
		if(result>0){
			model.addAttribute("board",boardService.getBoard(board));
			return "/board/boardView";
		}
		return "/board/boardModify";
	}
	@RequestMapping(value="/board/boardRemove", method = RequestMethod.GET)
	public String boardDelete(Board board){
		//System.out.println("boardDelete GET 호출");
		//System.out.println("boardNo:"+board.getBoardNo());
		//model.addAttribute("boardNo",board.getBoardNo());
		
		return "/board/boardRemove";
	}
	@RequestMapping(value="/board/boardRemove", method = RequestMethod.POST)
	public String boardDelete(Model model, Board board){
		System.out.println("boardDelete POST 호출");
		int result = boardService.removeBoard(board);
		System.out.println("result:"+result);
		
		if(result >0){
			return "redirect:/board/boardList";
		}
		//model.addAttribute("boardNo",board.getBoardNo());
		return "/board/boardRemove";
	}
}
