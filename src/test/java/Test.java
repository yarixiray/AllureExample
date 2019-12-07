import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import pojo.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@Epic("EndPoint")
@Feature("Class creation")
public class Test {

  @org.junit.jupiter.api.Test
  @Story("Main story")
  @Description("EndpoINT description")
  @DisplayName("Frodo test")
  public void test() {
    ResponseDTO res = getResponse().as(ResponseDTO.class);
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(list1()).as("Wrong size").hasSize(3);
    softAssertions.assertThat(list1()).as("Arrays are not equal").isEqualTo(list2());
    softAssertions
        .assertThat(res)
        .as("Fail here")
        .isEqualToComparingFieldByField(expectedRestult());
    softAssertions.assertAll();
  }

  private static ResponseDTO expectedRestult() {
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setOrigin("89.64.62.71, 89.64.62.71");
    responseDTO.setUrl("https://httpbin.org/get");
    return responseDTO;
  }

  private static Response getResponse() {
    return given()
        .when()
        .get("https://httpbin.org/get")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .extract()
        .response();
  }

  private static List list1() {
    List<ResponseDTO> list1 = new ArrayList<>();
    list1.add(expectedRestult());
    list1.add(expectedRestult());
    list1.add(expectedRestult());
    return list1;
  }

  public static List list2() {
    List<ResponseDTO> list1 = new ArrayList<>();
    list1.add(expectedRestult());
    list1.add(expectedRestult());
    list1.add(expectedRestult());
    return list1;
  }

  @org.junit.jupiter.api.Test
  public void drobTest() {
    Drob drob1 = new Drob(1, 2);
    Drob drob2 = new Drob(3, 4);
    SoftAssertions softAssertions = new SoftAssertions();
    softAssertions.assertThat(drob1.getNumerator()).isEqualTo(1);
    softAssertions.assertThat(drob2.getDenum()).isEqualTo(4);
    softAssertions.assertThat(SecondTest.drobSummary(drob1, drob2).getDenum()).isEqualTo(8);
    softAssertions.assertThat(SecondTest.drobSummary(drob1, drob2).getNumerator()).isEqualTo(10);
    softAssertions.assertAll();
  }
}
