package com.sivalabs.bookstore.promotions.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.sivalabs.bookstore.promotions.common.AbstractIntegrationTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

class PromotionControllerTest extends AbstractIntegrationTest {

    @Test
    void shouldGetAllPromotions() {

        given().contentType(ContentType.JSON)
                .when()
                .get("/api/promotions?productCodes=P100,P101")
                .then()
                .statusCode(200)
                .body(".", hasSize(promotions.size()));
    }

    @Test
    void shouldGetPromotionByProductCode() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/promotions/{productCode}", "P100")
                .then()
                .statusCode(200)
                .body("productCode", is("P100"))
                .body("discount", is(2));
    }

    @Test
    void shouldReturnZeroDiscountWhenPromotionNotExists() {
        given().contentType(ContentType.JSON)
                .when()
                .get("/api/promotions/{productCode}", "invalid_product_code")
                .then()
                .statusCode(200)
                .body("productCode", is("invalid_product_code"))
                .body("discount", is(0));
    }
}
