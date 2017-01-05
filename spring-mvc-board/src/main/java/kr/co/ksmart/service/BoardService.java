package kr.co.ksmart.service;

import java.util.Map;

public interface BoardService {
	int addBoard(Board board);
	Map<String, Object> getBoardListPerCurrentPage(int currentPage);
	Board getBoard(Board board);
	int modifyBoard(Board board);
}
