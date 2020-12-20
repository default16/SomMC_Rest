package com.rasulberov.reports.restclient.services;

import com.rasulberov.reports.dto.Employee;
import com.rasulberov.reports.dto.UserData;
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
    public List<Employee> getData() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apiUrl);

        UserData data = restTemplate.getForObject(builder.toUriString(), UserData.class);
        return data.getData();
    }

}
