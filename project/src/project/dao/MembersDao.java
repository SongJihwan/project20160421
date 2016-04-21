package project.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import project.annotation.Component;
import project.domain.Members;

@Component
public class MembersDao {
  SqlSessionFactory sqlSessionFactory;
  
  public MembersDao() {}
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Members> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectList("MembersDao.selectList");
    } finally {
      sqlSession.close();
    }
  }
  
  public Members selectOne(String name) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("String", name);
      return sqlSession.selectOne("MembersDao.selectOne", paramMap);
    } finally {
      sqlSession.close();
    }
  }
  
  public Members selectOneUpdate(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("no", no);
      return sqlSession.selectOne("MembersDao.selectOneUpdate", paramMap);
    } finally {
      sqlSession.close();
    }
  }
  
  public Members selectOneByEmail(String email) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("email", email);
      return sqlSession.selectOne("MembersDao.selectOne", paramMap);
    } finally {
      sqlSession.close();
    } 
    
  }
  
  public int insert(Members members) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    
    try {
      return sqlSession.insert("MembersDao.insert", members);
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int update(Members members) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.update("MembersDao.update", members);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }
  
  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      int count = sqlSession.delete("MembersDao.delete", no);
      sqlSession.commit();
      return count;
      
    } finally {
      sqlSession.close();
    }
  }

  public boolean isMembers(String email, String password) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      HashMap<String,String> paramMap = new HashMap<>();
      paramMap.put("email", email);
      paramMap.put("password", password);
      
      int count = sqlSession.selectOne("MembersDao.isMembers", paramMap);
      
      if (count > 0) 
        return true;
      else 
        return false;
      
    } finally {
      sqlSession.close();
    }
  }

}











