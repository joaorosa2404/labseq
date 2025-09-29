package labseq;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class LabseqControllerTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/labseq")
          .then()
             .statusCode(200)
             .body(is("Hello Spring"));
    }

}