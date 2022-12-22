package utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {

    @BeforeAll
   public static void init() {
        baseURI ="http://44.212.37.188:7000/api";

    }
}
