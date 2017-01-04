package kr.co.ksmart.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public int boardInsert(Board board) {
		System.out.println("BoardServiceImpl.boardInsert()");
		// TODO Auto-generated method stub
		return boardDao.boardAdd(board);
	}

}	
