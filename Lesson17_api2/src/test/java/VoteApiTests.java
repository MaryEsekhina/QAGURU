import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.hamcrest.Matchers.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class VoteApiTests {
    private String userCookie = null;

    @Test
    public void voteTest() {
        step ("Попытка голосования для анонимного пользователя",() -> {
        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body("pollAnswerId=2")
                        .when()
                        .post("http://demowebshop.tricentis.com/poll/vote")
                        .then()
                        .statusCode(200)
                        // .contentType(JSON)
                        .body("error", is("Only registered users can vote."))
                        .extract().response();

        System.out.println("Response: " + response.path("error"));});
    }

    @Test
    public void voteLoggedinTest() {


        step ("Получение куков авторизации",() -> {
       userCookie = given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", "bukva_zu@list.ru")
                .formParam("Password", "ser1991")
                .when()
                .post("http://demowebshop.tricentis.com/login")
                .then()
                .statusCode(302)
                .extract().cookie("NOPCOMMERCE.AUTH");});

        step ("Голосование авторизованного пользователя",() -> {
        Response response =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .cookie("NOPCOMMERCE.AUTH",userCookie)
                        .body("pollAnswerId=2")
                        .when()
                        .post("http://demowebshop.tricentis.com/poll/vote")
                        .then()
                        .statusCode(200)
                        //.body("html",)
                        .extract().response();

        assertThat(response.path("html").toString()).contains("<div class=\"poll\" id=\"poll-block-1");});

    }
}