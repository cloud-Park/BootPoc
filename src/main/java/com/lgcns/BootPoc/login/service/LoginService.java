package com.lgcns.BootPoc.login.service;

import com.lgcns.BootPoc.board.dto.BoardDto;
import com.lgcns.BootPoc.framework.dataaccess.CommonDao;
import com.lgcns.BootPoc.login.dto.LoginUserDto;
import com.lgcns.BootPoc.template.hello.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final CommonDao commonDao;

    public boolean save(LoginUserDto userDto){
        if(commonDao.insert("login.Login.insertUser",userDto)>0)
            return true;
        return false;
    }
    public LoginUserDto searchByEmail(String email){
        LoginUserDto loginUserDto = commonDao.select("login.Login.searchByEmail", email);
        return loginUserDto;
    }
    public void update(){

    }
    public void delete(String email){
        commonDao.delete(email);
    }
}
