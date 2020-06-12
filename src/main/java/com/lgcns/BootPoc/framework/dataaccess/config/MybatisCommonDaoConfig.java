package com.lgcns.BootPoc.framework.dataaccess.config;

import com.lgcns.BootPoc.framework.dataaccess.CommonDao;
import com.lgcns.BootPoc.framework.dataaccess.mybatis.MybatisCommonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisCommonDaoConfig {
    @Bean
    public CommonDao commonDao(){
        return new MybatisCommonDao();
    }
}
