package kr.co.ksmart.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int addBoard(Board board) {
		System.out.println("BoardServiceImpl.addBoard()");
		// TODO Auto-generated method stub
		return boardDao.insertBoard(board);
	}

	@Override
	public Map<String, Object> getBoardListPerCurrentPage(int currentPage) {
		System.out.println("BoardServiceImpl.getBoardListPerCurrentPage()");
		
		int pagePerRow = 10;
		int beginRow = (currentPage -1)*pagePerRow;
		int totalRowCount = boardDao.selectTotalBoardCount();
		int lastPage = totalRowCount/pagePerRow;
		if(totalRowCount%pagePerRow != 0) {
            lastPage++;
        }

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("beginRow", beginRow);
		map.put("pagePerRow", pagePerRow);
		List<Board> list = boardDao.selectBoardListPerPage(map);
		System.out.println("BoardList : "+list);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("totalRowCount", totalRowCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("list", list);
		return returnMap;
	}

	@Override
	public Board getBoard(Board board) {
		return boardDao.selectBoard(board);
	}
	
}
