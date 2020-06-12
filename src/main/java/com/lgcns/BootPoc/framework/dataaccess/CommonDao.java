package com.lgcns.BootPoc.framework.dataaccess;


import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CommonDao {
    <T> T select(String var1);

    <T> T select(String var1, Object var2);

    <E> List<E> selectList(String var1);

    <E> List<E> selectList(String var1, Object var2);

    <E> List<E> selectList(String var1, Object var2, String var3);

    <E> List<E> selectList(String var1, Object var2, RowBounds var3);

    <E> List<E> selectList(String var1, Object var2, String var3, RowBounds var4);

    <T> void selectList(String var1, ResultHandler<T> var2);

    <T> void selectList(String var1, Object var2, ResultHandler<T> var3);

    <E> List<E> selectPagedList(String var1, Object var2);

    <E> List<E> selectPagedList(String var1, Object var2, boolean var3);

    <E> List<E> selectPagedList(String var1, Object var2, String var3);

    <E> List<E> selectPagedList(String var1, Object var2, String var3, boolean var4);

    <E> List<E> selectScrollPagedList(String var1, Object var2);

    <E> List<E> selectScrollPagedList(String var1, Object var2, String var3);

    <E> List<E> selectScrollPagedList(String var1, Object var2, boolean var3);

    <E> List<E> selectScrollPagedList(String var1, Object var2, String var3, boolean var4);

    int insert(String var1);

    int insert(String var1, Object var2);

    int insert(String var1, Object var2, String var3);

    int update(String var1);

    int update(String var1, Object var2);

    int update(String var1, Object var2, String var3);

    int delete(String var1);

    int delete(String var1, Object var2);

    int delete(String var1, Object var2, String var3);

    int batchInsert(String var1, List<?> var2);

    int batchInsert(String var1, List<?> var2, boolean var3);

    int batchInsert(String var1, List<?> var2, String var3);

    int batchInsert(String var1, List<?> var2, String var3, boolean var4);

    int batchUpdate(String var1, List<?> var2);

    int batchUpdate(String var1, List<?> var2, boolean var3);

    int batchUpdate(String var1, List<?> var2, String var3);

    int batchUpdate(String var1, List<?> var2, String var3, boolean var4);

    int batchDelete(String var1, List<?> var2);

    int batchDelete(String var1, List<?> var2, boolean var3);

    int batchDelete(String var1, List<?> var2, String var3);

    int batchDelete(String var1, List<?> var2, String var3, boolean var4);
}