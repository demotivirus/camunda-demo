package com.example.camunda.RestTemplateTest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class WeathersRestConnect {
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        ITS_WORK();
        testRestConnector();
        testRestConnector2();
        ITS_WORK();
    }
    private static void testRestConnector(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity < String > entity = new HttpEntity < String > ("parameters", headers);
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=Naberezhnye Chelny&appid=6e3402343dbaeb622fa51ac79ed6e839";
        ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.GET, entity, String.class);

        System.out.println(result);
    }

    private static void testRestConnector2() {
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=Naberezhnye Chelny&appid=6e3402343dbaeb622fa51ac79ed6e839";
        ResponseEntity<String> user = restTemplate.getForEntity(URL, String.class);
        HttpStatus statusCode = user.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = user.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = user.getHeaders();
        System.out.println("response Headers - " + responseHeaders);
    }

    private static void ITS_WORK(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=Naberezhnye Chelny&appid=6e3402343dbaeb622fa51ac79ed6e839";
        ResponseEntity<String> result =
                restTemplate.exchange(URL, HttpMethod.GET, requestEntity, String.class);
        HttpStatus statusCode = result.getStatusCode();
        System.out.println("status code - " + statusCode);
        String userDetails = result.getBody();
        System.out.println("response body - " + userDetails);
        HttpHeaders responseHeaders = result.getHeaders();
        System.out.println("response Headers - " + responseHeaders);

        ResponseEntity<Weather> weatherResponseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, requestEntity, Weather.class);
        Weather weather = weatherResponseEntity.getBody();
        System.out.println("Weather body " + weatherResponseEntity.getBody());
        System.out.println(weather.getCoord().getLat() + "\n" + weather.getCoord().getLon());
    }
}
