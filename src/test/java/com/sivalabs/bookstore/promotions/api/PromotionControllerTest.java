package com.sivalabs.bookstore.promotions.api;

import com.sivalabs.bookstore.common.AbstractIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

class PromotionControllerTest extends AbstractIntegrationTest {

    @Test
    void shouldGetAllProducts() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/promotions?isbn=P100,P101")
                .then()
                .statusCode(200)
                .body(".", hasSize(promotions.size()));
    }

    @Test
    void shouldGetPromotionByIsbn() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/promotions/{isbn}", "P100")
                .then()
                .statusCode(200)
                .body("isbn", is("P100"))
                .body("discount", is(2));
    }

    @Test
    void shouldReturnNotFoundWhenPromotionNotExists() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/promotions/{isbn}", "invalid_isbn")
                .then()
                .statusCode(404);
    }
}