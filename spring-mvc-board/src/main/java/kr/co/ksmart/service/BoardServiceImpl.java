package kr.co.ksmart.service;

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

}
