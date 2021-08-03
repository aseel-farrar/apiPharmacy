package com.example.apiPharmacy.jasonToObject;

import java.util.Map;

/**
 * class used to map the json file from the API to object
 */
public class DrugApi {
    private Map<String, Object>[] data;

    public Map<String, Object>[] getData() {
        return data;
    }

}
