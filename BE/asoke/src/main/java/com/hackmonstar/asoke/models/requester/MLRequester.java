package com.hackmonstar.asoke.models.requester;

public class MLRequester {
    private Float grid_lat;
    private Float grid_lng;
    private String ts;
    private Integer density;

    public Float getGrid_lat() {
        return grid_lat;
    }

    public void setGrid_lat(Float grid_lat) {
        this.grid_lat = grid_lat;
    }

    public Float getGrid_lng() {
        return grid_lng;
    }

    public void setGrid_lng(Float grid_lng) {
        this.grid_lng = grid_lng;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Integer getDensity() {
        return density;
    }

    public void setDensity(Integer density) {
        this.density = density;
    }
}
