package dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomVisionReturned {
    private String id;
    private String project;
    private String iteration;
    private String created;
    private List<PredictionDto> predictions;
}
