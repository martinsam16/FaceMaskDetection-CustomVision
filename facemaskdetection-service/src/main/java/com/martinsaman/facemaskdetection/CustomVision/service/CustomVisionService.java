package com.martinsaman.facemaskdetection.CustomVision.service;

import com.martinsaman.facemaskdetection.CustomVision.client.CustomVisionClient;
import com.martinsaman.facemaskdetection.CustomVision.dto.CustomVisionReturned;
import com.martinsaman.facemaskdetection.CustomVision.dto.CustomVisionSended;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CustomVisionService {
    @Autowired
    private CustomVisionClient client;

    private static final String PREDICTION_KEY = "19458cc3f34343b8ada735c605165471";

    public CustomVisionReturned fromUrl(CustomVisionSended customVisionSended) {
        return client.fromUrl(PREDICTION_KEY, customVisionSended);
    }

    public CustomVisionReturned fromImage(MultipartFile image) {
        return client.fromImage(PREDICTION_KEY, image);
    }
}
