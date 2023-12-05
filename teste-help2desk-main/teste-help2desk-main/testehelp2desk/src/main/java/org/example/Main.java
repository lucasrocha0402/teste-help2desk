package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Product;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class Main {
    public static void main(String[] args)  {

        RestTemplate restTemplate = new RestTemplate();

        // Faz a requisição GET para obter os dados da API
        String apiUrl = "https://fakestoreapi.com/products";
        ParameterizedTypeReference<List<Product>> responseType = new ParameterizedTypeReference<List<Product>>() {};
        ResponseEntity<List<Product>> resp = restTemplate.exchange(apiUrl, HttpMethod.GET, null, responseType);
        List<Product> jsonResponse = resp.getBody();
        // Exibe os dados retornados
        jsonResponse.stream()
               .forEach(p-> {
                   try {
                       System.out.println(new ObjectMapper().writeValueAsString(p));
                   } catch (JsonProcessingException e) {
                       throw new RuntimeException(e);
                   }
               });
    }
}