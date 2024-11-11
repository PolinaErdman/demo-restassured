package by.tabletka;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest {

    @Test
    public void test1() {
        given()
                .body(LoginRequest.getBody())
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));
    }

    @Test
    public void test2() {
        String bodyRequest = "";

        given()
                .body(bodyRequest)
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(400)
                .body(equalTo("Bad Request (#400): Unable to verify your data submission."));
    }

    @Test
    public void test3NoEmail() {
        String bodyRequest = "_csrf=nsynP4U7Tnpd4YKHI6VC7zxBesqnLuCaAGGZtG1nVIncm_FUzHUALWyw0PJmlBKVCyQb-PVrtM5GA9PVPBQe2g%3D%3D&email=&password=test&rememberMe=on";

        given()
                .body(bodyRequest)
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));
    }

    @Test
    public void test4NoPassword() {
        String bodyRequest = "_csrf=nsynP4U7Tnpd4YKHI6VC7zxBesqnLuCaAGGZtG1nVIncm_FUzHUALWyw0PJmlBKVCyQb-PVrtM5GA9PVPBQe2g%3D%3D&email=test%40test.com&password=&rememberMe=on";

        given()
                .body(bodyRequest)
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));
    }

    @Test
    public void test5NoHeaderX() {
        String bodyRequest = "_csrf=nsynP4U7Tnpd4YKHI6VC7zxBesqnLuCaAGGZtG1nVIncm_FUzHUALWyw0PJmlBKVCyQb-PVrtM5GA9PVPBQe2g%3D%3D&email=test%40test.com&password=test&rememberMe=on";

        given()
                .body(bodyRequest)
                .header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
                .header("Cookie", "regionId=0; PHPSESSID=1fuvmodc25ao3l5oro5agqocm8; _csrf=f584bf9dbf4af44aa97824b015db98ef4050b3fc8ba929346190a818b7a0e58ea%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22BWVkINNW1QRuE1Pz7ea2RETTFbJaQsJS%22%3B%7D; _ga=GA1.1.1637374506.1731263387; __gads=ID=7d8be73a7d721454:T=1731263387:RT=1731263387:S=ALNI_MZzJzZq2RcjAXjCOi6cZ_kpPDxoAA; __gpi=UID=00000f8e83624d7c:T=1731263387:RT=1731263387:S=ALNI_MZLj-w82y4K84FYRyXtr5iL-p1MrQ; __eoi=ID=cc787bd40bb5e30c:T=1731263387:RT=1731263387:S=AA-AfjahkOlLp0XVOo3xhInlTZjR; _ga_S6LL4MRH46=GS1.1.1731263386.1.1.1731263402.0.0.0; allow-cookies=")
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1));
    }

    @Test
    public void test6NoCsrf() {
        String bodyRequest = "_csrf=&email=test%40test.com&password=test&rememberMe=on";

        given()
                .body(bodyRequest)
                .headers(LoginRequest.getHeaders())
        .when()
                .post(LoginRequest.URL_LOGIN)
        .then()
                .log().all()
                .statusCode(400)
                .body(equalTo("Bad Request (#400): Unable to verify your data submission."));
    }
}
