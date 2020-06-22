package com.lgcns.BootPoc.login.service;

import com.lgcns.BootPoc.board.dto.BoardDto;
import com.lgcns.BootPoc.framework.dataaccess.CommonDao;
import com.lgcns.BootPoc.login.dto.LoginUserDto;
import com.lgcns.BootPoc.template.hello.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class LoginService {
    private final CommonDao commonDao;

    @Transactional
    public LoginUserDto searchByEmail(String email){
        log.info("email="+email);
        LoginUserDto loginUserDto = commonDao.select("login.Login.searchByEmail", email);
        log.info("loginUserDto="+loginUserDto);
        return loginUserDto;
    }

    @Transactional
    public boolean save(LoginUserDto userDto){
        if(commonDao.insert("login.Login.insertUser",userDto)>0)
            return true;
        return false;
    }

    @Transactional
    public void update(LoginUserDto userDto){
        commonDao.select("login.Login.updateUser", userDto);
    }
    @Transactional
    public void delete(String email){
        commonDao.delete("login.Login.deleteUser", email);
    }
}
