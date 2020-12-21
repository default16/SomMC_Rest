package com.rasulberov.reports.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Serializable {
    private static final long serialVersionUID = 3119445011787783145L;
    private List<Employee3> data = new ArrayList<>();

    public List<Employee3> getData() {
        return data;
    }

    public void addData(Employee3 employee3) {
        data.add(employee3);
    }
}
