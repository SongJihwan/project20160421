package project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import project.annotation.Component;
import project.domain.Project;

@Component
public class ProjectDao {
  SqlSessionFactory sqlSessionFactory;

  public ProjectDao() {}  

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;

  }

  public List<Project> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectList("ProjectDao.selectList");

    } finally {
      sqlSession.close();

    }
  }
  
  public Project selectOne(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne("ProjectDao.selectOne", no);

    } finally {
      sqlSession.close();

    }
  }

  public int insert(Project project) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    try {
      return sqlSession.insert("ProjectDao.insert", project);

    } finally {
      sqlSession.close();
    }

  }
  
  public int update(Project project) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
       int count = sqlSession.update("ProjectDao.update", project);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }


  public int delete(int no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      int count = sqlSession.delete("ProjectDao.delete", no);
      sqlSession.commit();
      return count;

    } finally {
      sqlSession.close();
    }
  }

  


}