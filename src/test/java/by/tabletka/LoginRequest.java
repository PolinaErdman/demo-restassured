package by.tabletka;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static final String URL_LOGIN = "https://tabletka.by/ajax-request/login";

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("Cookie", "regionId=0; PHPSESSID=1fuvmodc25ao3l5oro5agqocm8; _csrf=f584bf9dbf4af44aa97824b015db98ef4050b3fc8ba929346190a818b7a0e58ea%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22BWVkINNW1QRuE1Pz7ea2RETTFbJaQsJS%22%3B%7D; _ga=GA1.1.1637374506.1731263387; __gads=ID=7d8be73a7d721454:T=1731263387:RT=1731263387:S=ALNI_MZzJzZq2RcjAXjCOi6cZ_kpPDxoAA; __gpi=UID=00000f8e83624d7c:T=1731263387:RT=1731263387:S=ALNI_MZLj-w82y4K84FYRyXtr5iL-p1MrQ; __eoi=ID=cc787bd40bb5e30c:T=1731263387:RT=1731263387:S=AA-AfjahkOlLp0XVOo3xhInlTZjR; _ga_S6LL4MRH46=GS1.1.1731263386.1.1.1731263402.0.0.0; allow-cookies=");
        headers.put("X-Requested-With", "XMLHttpRequest");
        return headers;
    }
    public static String getBody() {
        return "_csrf=nsynP4U7Tnpd4YKHI6VC7zxBesqnLuCaAGGZtG1nVIncm_FUzHUALWyw0PJmlBKVCyQb-PVrtM5GA9PVPBQe2g%3D%3D&email=test%40test.com&password=test&rememberMe=on";
    }
}
