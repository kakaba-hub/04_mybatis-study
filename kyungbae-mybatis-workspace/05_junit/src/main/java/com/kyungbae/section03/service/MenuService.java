package com.kyungbae.section03.service;

import com.kyungbae.section03.dao.MenuMapper;
import com.kyungbae.section03.dto.CategoryDto;
import com.kyungbae.section03.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.kyungbae.section03.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDto> selectMenuList() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.selectAllMenu();
        sqlSession.close();
        return list;
    }

    public List<CategoryDto> selectCategory() {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<CategoryDto> list = menuMapper.selectCategory();
        sqlSession.close();
        return list;
    }

    public MenuDto selectMenuByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menu = menuMapper.selectMenuByMenuCode(menuCode);
        sqlSession.close();
        return menu;
    }

    public List<MenuDto> selectMenuListByCategoryCode(int categoryCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.selectMenuByCategoryCode(categoryCode);
        sqlSession.close();
        return list;
    }

    public int registMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = 0;

        // 정상적인 데이터 (일반적으로 FK 위반) 이 발생시
        // 예외처리를 통해서 반환 (if(result > 0) 대신)
        try {
            result = menuMapper.insertMenu(menu);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return result;
    }

    public int modifyMenu(MenuDto menu) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = 0;

        try {
            result = menuMapper.updateMenu(menu);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return result;
    }

    public int removeMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = 0;

        try {
            result = menuMapper.deleteMenu(menuCode);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            sqlSession.close();
        }

        return result;
    }
}
