package cydeo.spartan.editor;


import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utilities.SpartanTestBase;
import utilities.SpartanUtil;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;

@SerenityTest
public class SpartanEditorTest extends SpartanTestBase {

    @DisplayName("POST /spartan as editor")
    @Test
    public void postSpartan() {

        Map<String, Object> spartanMap = SpartanUtil.getRandomSpartanMap();
        System.out.println("spartanMap = " + spartanMap);


        given().auth().basic("editor","editor")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(spartanMap). // SERIALIZATION
        when().post("/spartans").prettyPeek();

        /*

        SERIALIZATION  --> JAVA/POJO  to JSON
        DESERILIZATION --> JSON to JAVA/POJO

        Do we need to add dependency?
        - With Regular Rest Assured we were adding JACKSON Databind for DESERILIZATION and SERIALIZATION

        - For Serenity we are not gonna add Jackson / GSON or other databind / objectMapper dependency


         */

        /*
                status code is 201
                content type is Json
                success message is A Spartan is Born!
                id is not null
                name is correct
                gender is correct
                phone is correct

                check location header ends with newly generated id
         */


    }
}
