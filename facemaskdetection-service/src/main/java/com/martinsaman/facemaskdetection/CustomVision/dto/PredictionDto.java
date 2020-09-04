package com.martinsaman.facemaskdetection.CustomVision.dto;

import lombok.Data;

@Data
public class PredictionDto {
    private Double probability;
    private String tagId;
    private String tagName;
}
