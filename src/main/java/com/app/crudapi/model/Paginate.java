package com.app.crudapi.model;

import lombok.Data;

@Data
public class Paginate {
    private int page;
    private int limit;
    private long totalData;
    private long totalPage;
}
