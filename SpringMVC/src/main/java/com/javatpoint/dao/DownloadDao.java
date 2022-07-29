package com.javatpoint.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javatpoint.beans.download;

@Repository()
public class DownloadDao {
	
	@Autowired
	SqlSession sqlSession;

	public int save(download p){    
	    int result = sqlSession.insert("Download.save", p);
	    return result;
	}    
	public int update(download p){    
		int result = sqlSession.insert("Download.update", p);
	    return result; 
	}    
	public int delete(int id){    
		int result = sqlSession.insert("Download.delete", id);
	    return result;    
	}    
	public download getDownloadsById(int id){    
	    download dl = sqlSession.selectOne("Download.getDownloadsById", id); 
	    return dl;
	}    
	public List<download> getDownloads(String user_ip){    
		List<download> downList = sqlSession.selectList("Download.getDownloads", user_ip);
		return downList;
	}    
}
