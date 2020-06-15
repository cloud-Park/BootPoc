package com.lgcns.BootPoc.framework.dataaccess.mybatis;

import com.lgcns.BootPoc.framework.dataaccess.CommonDao;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MybatisCommonDao implements CommonDao, InitializingBean {

    @Autowired
    protected SqlSessionTemplate sqlSessionTemplate;

   private String a = "sqlSessionFactory";
    protected Map<String, SqlSession> localSqlSessionMap = new HashMap();


   /*public MybatisCommonDao(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }*/

    @Override
    public <T> T select(String var1) {
        return sqlSessionTemplate.selectOne(var1);
    }

    @Override
    public <T> T select(String var1, Object var2) {
        return sqlSessionTemplate.selectOne(var1, var2);
    }

    @Override
    public <E> List<E> selectList(String var1) {
        return sqlSessionTemplate.selectList(var1);
    }

    @Override
    public <E> List<E> selectList(String var1, Object var2) {
        return sqlSessionTemplate.selectList(var1, var2);
    }

    @Override
    @Cacheable(value = "SelectOneCache", key = "#var1 + '.' + #var2")
    public <T> T selectWithCache(String var1, String var2) {
        return select(var1);
    }

    @Override
    @Cacheable(value = "SelectOneCache", key = "#var1 + '.' + #var3")
    public <T> T selectWithCache(String var1, Object var2, String var3) {
        return select(var1, var2);
    }

    @Override
    @Cacheable(value = "SelectListCache", key = "#var1 + '.' + #var2")
    public <E> List<E> selectListWithCache(String var1, String var2) {
        return selectList(var1);
    }

    @Override
    @Cacheable(value = "SelectListCache", key = "#var1 + '.' + #var3")
    public <E> List<E> selectListWithCache(String var1, Object var2, String var3) {
        return selectList(var1, var2);
    }

    @Override
    public <E> List<E> selectList(String var1, Object var2, String var3) {
        return null;
    }

    @Override
    public <E> List<E> selectList(String var1, Object var2, RowBounds var3) {
        return sqlSessionTemplate.selectList(var1, var2, var3);
    }

    @Override
    public <E> List<E> selectList(String var1, Object var2, String var3, RowBounds var4) {
        return null;
    }

    @Override
    public <T> void selectList(String var1, ResultHandler<T> var2) {

    }

    @Override
    public <T> void selectList(String var1, Object var2, ResultHandler<T> var3) {

    }

    @Override
    public <E> List<E> selectPagedList(String var1, Object var2) {
        return null;
    }

    @Override
    public <E> List<E> selectPagedList(String var1, Object var2, boolean var3) {
        return null;
    }

    @Override
    public <E> List<E> selectPagedList(String var1, Object var2, String var3) {
        return null;
    }

    @Override
    public <E> List<E> selectPagedList(String var1, Object var2, String var3, boolean var4) {
        return null;
    }

    @Override
    public <E> List<E> selectScrollPagedList(String var1, Object var2) {
        return null;
    }

    @Override
    public <E> List<E> selectScrollPagedList(String var1, Object var2, String var3) {
        return null;
    }

    @Override
    public <E> List<E> selectScrollPagedList(String var1, Object var2, boolean var3) {
        return null;
    }

    @Override
    public <E> List<E> selectScrollPagedList(String var1, Object var2, String var3, boolean var4) {
        return null;
    }

    @Override
    public int insert(String var1) {
        return sqlSessionTemplate.insert(var1);
    }

    @Override
    public int insert(String var1, Object var2) {
        return sqlSessionTemplate.insert(var1,var2);
    }

    @Override
    public int insert(String var1, Object var2, String var3) {
        return 0;
    }

    @Override
    public int update(String var1) {
        return sqlSessionTemplate.update(var1);
    }

    @Override
    public int update(String var1, Object var2) {
        return sqlSessionTemplate.update(var1, var2);
    }

    @Override
    public int update(String var1, Object var2, String var3) {
        return 0;
    }

    @Override
    public int delete(String var1) {
        return sqlSessionTemplate.delete(var1);
    }

    @Override
    public int delete(String var1, Object var2) {
        return sqlSessionTemplate.delete(var1, var2);
    }

    @Override
    public int delete(String var1, Object var2, String var3) {
        return 0;
    }

    @Override
    public int batchInsert(String var1, List<?> var2) {
        return 0;
    }

    @Override
    public int batchInsert(String var1, List<?> var2, boolean var3) {
        return 0;
    }

    @Override
    public int batchInsert(String var1, List<?> var2, String var3) {
        return 0;
    }

    @Override
    public int batchInsert(String var1, List<?> var2, String var3, boolean var4) {
        return 0;
    }

    @Override
    public int batchUpdate(String var1, List<?> var2) {
        return 0;
    }

    @Override
    public int batchUpdate(String var1, List<?> var2, boolean var3) {
        return 0;
    }

    @Override
    public int batchUpdate(String var1, List<?> var2, String var3) {
        return 0;
    }

    @Override
    public int batchUpdate(String var1, List<?> var2, String var3, boolean var4) {
        return 0;
    }

    @Override
    public int batchDelete(String var1, List<?> var2) {
        return 0;
    }

    @Override
    public int batchDelete(String var1, List<?> var2, boolean var3) {
        return 0;
    }

    @Override
    public int batchDelete(String var1, List<?> var2, String var3) {
        return 0;
    }

    @Override
    public int batchDelete(String var1, List<?> var2, String var3, boolean var4) {
        return 0;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
