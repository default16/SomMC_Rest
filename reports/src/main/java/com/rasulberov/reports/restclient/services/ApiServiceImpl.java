package com.rasulberov.reports.restclient.services;

import com.rasulberov.reports.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import static java.util.Arrays.asList;

@Service
public class ApiServiceImpl implements ApiService {
    private RestTemplate restTemplate;
    private String apiUrl;

    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api_url}")String apiUrl) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public List<Employee3> getData() {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(apiUrl);

//        Employee data = restTemplate.getForObject(builder.toUriString(), Employee.class);
//        myList.add(data);
        UserData data = restTemplate.getForObject(builder.toUriString(), UserData.class);

        Employee3 employee = restTemplate.getForObject(builder.toUriString(), Employee3.class);
        UserData data2 = new UserData();
        data2.addData(employee);

        return data2.getData();
    }

    @Override
    public Employee3[] getForEntityEmployeesAsArray() {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Employee3[]> response =
                restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos",
                        Employee3[].class);

        Employee3[] employees = response.getBody();

        assert employees != null;
        asList(employees).forEach(System.out::println);

        return employees;
    }

}
