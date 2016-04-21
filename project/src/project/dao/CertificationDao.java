package project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import project.annotation.Component;
import project.domain.Certification;

@Component
public class CertificationDao {
  SqlSessionFactory sqlSessionFactory;

  public CertificationDao() {}  

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;

  }

  public List<Certification> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    
    try {
      return sqlSession.selectList("CertificationDao.selectList");

    } finally {
      sqlSession.close();

    }
  }
  
  public Certification selectOne(String certificationName) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      return sqlSession.selectOne("CertificationDao.selectOne", certificationName);

    } finally {
      sqlSession.close();

    }
  }

  public int insert(Certification certification) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);

    try {
      return sqlSession.insert("CertificationDao.insert", certification);

    } finally {
      sqlSession.close();
    }

  }
  
  public int update(Certification certification) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
       int count = sqlSession.update("CertificationDao.update", certification);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }


  public int delete(String no) throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();

    try {
      int count = sqlSession.delete("CertificationDao.delete", no);
      sqlSession.commit();
      return count;

    } finally {
      sqlSession.close();
    }
  }

  


}