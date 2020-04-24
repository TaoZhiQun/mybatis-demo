package com.tao.test;

import com.tao.test.dao.UserDao;
import com.tao.test.entity.User;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author TaoZhiQun
 * @version v1.0
 * @desc main方法运行Mybatis
 * @date 2020-4-24 10:16
 */
public class MybatisTest {
    public static void main(String[] args) {
        try {
            final InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            final SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            final SqlSession sqlSession = sessionFactory.openSession();
            final UserDao userDao = sqlSession.getMapper(UserDao.class);
            final User user = userDao.selectByPrimaryKey(1L);
            System.out.println(user.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
