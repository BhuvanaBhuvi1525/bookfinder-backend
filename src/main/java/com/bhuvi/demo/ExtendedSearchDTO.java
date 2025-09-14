package com.bhuvi.demo;

import java.util.List;

public class ExtendedSearchDTO {
    private List<String> queries;

    public ExtendedSearchDTO() {}

    public ExtendedSearchDTO(List<String> queries) {
        this.queries = queries;
    }

    public List<String> getQueries() {
        return queries;
    }

    public void setQueries(List<String> queries) {
        this.queries = queries;
    }
}

