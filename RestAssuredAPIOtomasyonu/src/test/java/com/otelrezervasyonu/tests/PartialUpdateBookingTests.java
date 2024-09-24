package com.otelrezervasyonu.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PartialUpdateBookingTests extends BaseTest{

    @Test
    public  void  partialUptateBookingTest(){
        //token oluştur
        String token = createToken();

        //rezervasyon
        Response newBooking =createBooking();
        int bookingId = newBooking.jsonPath().getJsonObject("bookingid");

        //çağrıyı yap
      /*  curl -X PATCH \
        https://restful-booker.herokuapp.com/booking/1 \
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \
        -d '{
        "firstname" : "James",
                "lastname" : "Brown"
    }'

           */
        JSONObject body = new JSONObject();
        body.put("firstname","Şemsi");
        String data = "/booking/"+bookingId;
        String myBody = body.toString();

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+token)
                .body(myBody)
                .when()
                .patch(data);

        //assertion

    }
}
