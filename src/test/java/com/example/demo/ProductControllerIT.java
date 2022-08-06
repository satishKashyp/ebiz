package com.example.demo;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

//@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PaymentServiceSatish2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerIT {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveStudentCourse() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");

        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:8080/ebiz/product",
                HttpMethod.GET, entity, String.class);

        String expected = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Book\",\n" +
                "        \"price\": 10.0,\n" +
                "        \"description\": null\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Apparal\",\n" +
                "        \"price\": 20.0,\n" +
                "        \"description\": null\n" +
                "    }\n" +
                "]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

}
