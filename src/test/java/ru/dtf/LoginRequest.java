package ru.dtf;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static final String URL_LOGIN = "https://api.dtf.ru/v3.4/auth/email/login";

    public static String getBody() {
        return "email:dfgdfgdfg@test.com\n" +
                "password:dfgdfgdfg";
    }

    public static Map<String, String> getFormData() {
        Map <String, String> body = new HashMap<>();
        body.put("email", "test@test.com");
        body.put("password", "qwerty");
        return body;
    }
}
