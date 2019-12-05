package com.hackmonstar.asoke.models.responders;

import com.hackmonstar.asoke.models.GPS;

import java.util.Map;

public class GPSResponder {
    private Map<String, GPS> _data;

    public Map<String, GPS> get_data() {
        return _data;
    }

    public void set_data(Map<String, GPS> _data) {
        this._data = _data;
    }
}
