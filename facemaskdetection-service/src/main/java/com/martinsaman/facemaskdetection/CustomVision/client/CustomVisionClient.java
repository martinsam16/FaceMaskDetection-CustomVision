package com.martinsaman.facemaskdetection.CustomVision.client;

import com.martinsaman.facemaskdetection.CustomVision.dto.CustomVisionReturned;
import com.martinsaman.facemaskdetection.CustomVision.dto.CustomVisionSended;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(
        url = "https://southcentralus.api.cognitive.microsoft.com/customvision/v3.0/Prediction/" +
                "a26b276f-3a57-4921-82f2-b678c4b8f07a/classify/iterations/face_mask_detection_model",
        name = "customvision"
)
public interface CustomVisionClient {
    @PostMapping("/url")
    CustomVisionReturned fromUrl(@RequestHeader("Prediction-Key") String predictionKey,
                                 @RequestBody CustomVisionSended customVisionSended);

    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    CustomVisionReturned fromImage(@RequestHeader("Prediction-Key") String predictionKey,
                                   @RequestBody MultipartFile image);
}
