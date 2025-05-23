package com.jjanggu.section01.xml;

import com.jjanggu.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.jjanggu.section01.xml.Template.getSqlSession;

public class MenuService {

    private MenuDao menuDao = new MenuDao();

    public int insertMenu(MenuDto menu){
        SqlSession sqlSession = getSqlSession();
        int result = menuDao.insertMenu(sqlSession,menu);
        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }

    public int updateMenu(MenuDto menu){
        SqlSession sqlSession = getSqlSession();
        int result = menuDao.updateMenu(sqlSession, menu);
        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public int deleteMenu(int code){
        SqlSession sqlSession = getSqlSession();
        int result = menuDao.deleteMenu(sqlSession, code);
        if(result > 0){
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    public List<String> selectMenuNameList(){
        SqlSession sqlSession = getSqlSession();
        List<String> list = menuDao.selectMenuNameList(sqlSession);
        sqlSession.close();
        return list;
    }

    public List<MenuDto> selectOrderableMenuList(){
        SqlSession sqlSession = getSqlSession();
        List<MenuDto> list = menuDao.selectOrderableMenuList(sqlSession);
        sqlSession.close();
        return list;
    }

    public int selectOrderableMenuCount(){
        SqlSession sqlSession = getSqlSession();
        int count = menuDao.selectOrderableMenuCount(sqlSession);
        sqlSession.close();
        return count;
    }

    public MenuDto selectMenuByCode(int code){
        SqlSession sqlSession = getSqlSession();
        MenuDto menu = menuDao.selectMenuByCode(sqlSession, code);
        sqlSession.close();
        return menu;
    }
}
