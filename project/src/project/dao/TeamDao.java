package project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import project.annotation.Component;
import project.domain.Team;

@Component
public class TeamDao {
  SqlSessionFactory sqlSessionFactory;

  public TeamDao() {}  
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Team> selectList() throws Exception {
    
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("TeamDao.selectList");

  } finally {
      sqlSession.close();

    }
  }
  
  public Team selectOne(String code) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne("TeamDao.selectOne", code);

    } finally {
      sqlSession.close();

    }
  }

  public int insert(Team team) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    try {
      return sqlSession.insert("TeamDao.insert", team);

    } finally {
      sqlSession.close();
    }

  }
  
  public int update(Team team) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
       int count = sqlSession.update("TeamDao.update", team);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }


  public int delete(String code) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      int count = sqlSession.delete("TeamDao.delete", code);
      sqlSession.commit();
      return count;

    } finally {
      sqlSession.close();
    }
  }

  


}