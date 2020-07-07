package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

	@Autowired
	private SqlSession sqlSession;

	// 사람 출력하기
	public List<GuestbookVo> getPersonList() {
		List<GuestbookVo> gList = sqlSession.selectList("guestbook.getList");

		return gList;
	}

	// 사람 추가
	public int personInsert(GuestbookVo guestVo) {
		int count = sqlSession.insert("guestbook.insert", guestVo);

		return count;
	}
	
	// 사람 삭제 
	public int personDelete(GuestbookVo guestVo) { 
		int count = sqlSession.delete("guestbook.delete",guestVo);
				
		return count;
	}
		 
}
