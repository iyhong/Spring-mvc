package kr.co.ksmart.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int boardAdd(Board board) {
		System.out.println("BoardDaoImpl.boardAdd()");
		// TODO Auto-generated method stub
		return sqlSession.insert("kr.co.ksmart.board.service.BoardMapper.boardAdd", board);
	}

}
