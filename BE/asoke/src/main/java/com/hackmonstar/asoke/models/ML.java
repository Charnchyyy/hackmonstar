package com.hackmonstar.asoke.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "ml")
@IdClass(MLKey.class)
public class ML {
    @Id
    private Float grid_lat;
    @Id
    private Float grid_lng;
    @Id
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
