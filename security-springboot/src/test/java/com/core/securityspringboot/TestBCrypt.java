package com.core.securityspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class TestBCrypt {
    @Test
    public void testBCrypt(){
        //密码加密
        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
        System.out.println(hashpw);
        //校验密码
        boolean checkpw1 = BCrypt.checkpw("123", "$2a$10$hNV.UpnV9WJ8yR/W78T7COJsCANyA.zAlD27Uxv0aa7tQuteELPRK");
        boolean checkpw2 = BCrypt.checkpw("123", "$2a$10$fIYb3/Q/eNDJzJDlBTHo/.decx5fUnNtuMtBmCE5BtJj.cISVARgq");
        System.out.println(checkpw1);
        System.out.println(checkpw2);
    }
}
