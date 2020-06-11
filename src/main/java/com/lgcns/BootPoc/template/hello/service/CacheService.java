package com.lgcns.BootPoc.template.hello.service;

import com.lgcns.BootPoc.framework.util.cache.CacheUtil;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    public void save(){

    }
    public Object searchByKey(String key){

        return CacheUtil.searchData(key);
    }
    public void searchList(){

    }
    public void delete(){

    }
    public void modify(){

    }
}
