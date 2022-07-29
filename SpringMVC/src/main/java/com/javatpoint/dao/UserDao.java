package com.javatpoint.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatpoint.beans.UserVO;
import com.javatpoint.beans.download;

@Repository()
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;

	public UserVO getUser(UserVO vo){    
	    return sqlSession.selectOne("User.getUser", vo);
	}

}
