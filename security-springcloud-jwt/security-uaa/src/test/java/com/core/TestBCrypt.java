package com.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class TestBCrypt {
    @Test
    public void testBCrypt(){
        String secret = BCrypt.hashpw("secret", BCrypt.gensalt());
        System.out.println(secret);
    }
}
