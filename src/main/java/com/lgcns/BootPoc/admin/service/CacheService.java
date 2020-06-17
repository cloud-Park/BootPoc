package com.lgcns.BootPoc.admin.service;

import com.lgcns.BootPoc.framework.util.cache.CacheUtil;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    public boolean save(String key, Object data){
        return CacheUtil.saveData(key,data);
    }
    public Object searchByKey(String key){
        return CacheUtil.searchData(key);
    }
    public Object searchList(){
        return CacheUtil.searchList();
    }
    public boolean delete(String key){
        return CacheUtil.deleteData(key);
    }
    public boolean update(String key, Object data){
        return CacheUtil.updateData(key, data);
    }
}
