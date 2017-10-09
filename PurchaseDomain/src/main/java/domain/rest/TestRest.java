/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.rest;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Mauro
 */
public class TestRest {

    public static void main(String[] args) {
        Map parameters = new HashMap();
        parameters.put("q", "nexus6p");
        parameters.put("cx", "000944192720465307300:qbm11spsnzw");
        parameters.put("key", "AIzaSyBv9rRn3Zbjn0wYbdM6M6PXgrvnfHwvrm0");
        parameters.put("searchType", "image");
        parameters.put("num", "1");
        parameters.put("fields", "items/link");
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        Result result = restTemplate.getForObject("https://www.googleapis.com/customsearch/v1?q={q}&cx={cx}&searchType={searchType}&key={key}&num={num}&fields={fields}", Result.class, parameters);
        System.out.println("result: " + result.getItems().get(0).getLink());
    }
    public String getImageUrl(String title,String description){
        Map parameters = new HashMap();
        parameters.put("q", title+" "+description);
        parameters.put("cx", "000944192720465307300:qbm11spsnzw");
        parameters.put("key", "AIzaSyBv9rRn3Zbjn0wYbdM6M6PXgrvnfHwvrm0");
        parameters.put("searchType", "image");
        parameters.put("num", "1");
        parameters.put("fields", "items/link");
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(HttpClientBuilder.create().build());
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        Result result = restTemplate.getForObject("https://www.googleapis.com/customsearch/v1?q={q}&cx={cx}&searchType={searchType}&key={key}&num={num}&fields={fields}", Result.class, parameters);
        return result.getItems().get(0).getLink();
    }
}
