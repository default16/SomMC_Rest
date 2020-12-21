package com.rasulberov.reports.restclient.services;

import com.rasulberov.reports.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    private RestTemplate restTemplate;
    private String apiUrl;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api_url}")String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public Employee getData() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apiUrl);

        Employee data = restTemplate.getForObject(builder.toUriString(), Employee.class);
        return data;
    }

}
