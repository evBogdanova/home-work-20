package helpers;


import java.net.MalformedURLException;
import java.net.URL;

import static config.Project.browserstackConfig;
import static io.restassured.RestAssured.given;


public class BrowserstackHelper {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(String.format(browserstackConfig.url(), browserstackConfig.bsLogin(),
                    browserstackConfig.bsPassword()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowserstackVideoUrl(String sessionId) {
        String video_url = given()
                .auth().basic(browserstackConfig.bsLogin(), browserstackConfig.bsPassword())
                .when()
                .get(browserstackConfig.sessionsUrl() + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.video_url");

        System.out.println("video_url: " + video_url);
        return video_url;
    }

    public static String getBSPublicLink(String sessionId) {
        String publicUrl = given()
                .auth().basic(browserstackConfig.bsLogin(), browserstackConfig.bsPassword())
                .when()
                .get(browserstackConfig.sessionsUrl() + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.public_url");

        System.out.println("bs_public_url: " + publicUrl);
        System.out.println("bs_build_url: " + publicUrl.split("/sessions/")[0]);
        return publicUrl;
    }
}