package org.wikipedia.helpers;

import static io.restassured.RestAssured.given;
import static org.wikipedia.drivers.ConfigDriver.getAuthConfig;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(getAuthConfig().getLogin(), getAuthConfig().getPassword())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }

}
