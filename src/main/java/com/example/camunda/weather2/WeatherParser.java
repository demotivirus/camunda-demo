package com.example.camunda.weather2;

import com.example.camunda.weather2.model.Weather;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class WeatherParser implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String city = (String) delegateExecution.getVariable("city");
        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + city +"&appid=6e3402343dbaeb622fa51ac79ed6e839";
        double celsiusTemp = 0d;
        try {
            Weather weather = restTemplate.getForObject(new URI(URL), Weather.class);
            System.out.println(weather);
            celsiusTemp = Math.round(weather.getMain().getTemp() - 273.15);
            System.out.println("Celsius temp is " + celsiusTemp);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        delegateExecution.setVariable("celsiusTemp", celsiusTemp);
    }

    private static void test(){
        RestTemplate restTemplate = new RestTemplate();
        String URL = "https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=6e3402343dbaeb622fa51ac79ed6e839";

        try {
            Weather weather = restTemplate.getForObject(new URI(URL), Weather.class);
            System.out.println(weather);
            double celsiusTemp = weather.getMain().getTemp() - 273.15;
            System.out.println("Celsius temp is " + Math.round(celsiusTemp));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

//                HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
//            ResponseEntity<Weather> weatherResponseEntity =
//                    restTemplate.exchange(URL, HttpMethod.GET, requestEntity, Weather.class);
//            System.out.println(weatherResponseEntity);
    }
}
