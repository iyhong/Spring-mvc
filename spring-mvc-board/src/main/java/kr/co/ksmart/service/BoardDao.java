package kr.co.ksmart.service;

import java.util.List;
import java.util.Map;

public interface BoardDao {
	int insertBoard(Board board);
	List<Board> selectBoardListPerPage(Map<String, Integer> map);
	int selectTotalBoardCount();
	Board selectBoard(Board board);
	int updateBoard(Board board);
	int deleteBoard(Board board);
}
