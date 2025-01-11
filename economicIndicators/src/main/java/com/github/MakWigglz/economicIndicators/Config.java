package com.github.MakWigglz.economicIndicators;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class Config {
    private static Config instance;
    private JsonNode configData;

    private Config() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.json");
            if (inputStream == null) {
                throw new IOException("Unable to find config.json");
            }
            configData = mapper.readTree(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public String getAlphaVantageApiKey() {
        return configData.get("alphaVantageApiKey").asText();
    }

    public String getFredApiKey() {
        return configData.get("fredApiKey").asText();
    }
}