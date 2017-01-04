package kr.co.ksmart.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		System.out.println("BoardDaoImpl.insertBoard()");
		return sqlSession.insert("kr.co.ksmart.BoardMapper.boardAdd",board);
	}

}
