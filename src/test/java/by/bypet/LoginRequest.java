package by.bypet;

public class LoginRequest {
    public static final String URL_LOGIN = "https://bypet.by/auth/login";

    public static String getBody(String phoneStripped) {
        return "{\n" +
                "\"phone_stripped\":\"" + phoneStripped + "\",\n" +
                "\"phone\":\"+375 (33) 111-00-00\",\n" +
                "\"password\":\"qwertyui\"\n" +
                "}";
    }
}
