import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import pojo.ResponseDTO;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("EndPoint")
@Feature("Class creation")
public class Test {

    @org.junit.jupiter.api.Test
    @Story("Main story")
    @Description("EndpoINT description")
    public void test() {
        ResponseDTO res = getResponse().as(ResponseDTO.class);
        assertEquals(res, build());
    }

    private static ResponseDTO build() {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setOrigin("89.64.62.71, 89.64.62.71");
        responseDTO.setUrl("https://httpbin.org/get");
        return responseDTO;
    }

    private static Response getResponse() {
        return given().when()
                .get("https://httpbin.org/get")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
    }
}
