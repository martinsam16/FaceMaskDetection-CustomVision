package com.martinsaman.facemaskdetection.CustomVision.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustomVisionSended {
    @JsonProperty("Url")
    private String url;
}
