package com.martinsaman.facemaskdetection.CustomVision;

import com.martinsaman.facemaskdetection.CustomVision.dto.CustomVisionReturned;
import com.martinsaman.facemaskdetection.CustomVision.dto.CustomVisionSended;
import com.martinsaman.facemaskdetection.CustomVision.service.CustomVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
@CrossOrigin
public class CustomVisionRest {

    @Autowired
    private CustomVisionService service;

    @GetMapping
    public String healtCheck() {
        return "ok";
    }

    @PostMapping("/url")
    public CustomVisionReturned fromUrl(@RequestBody CustomVisionSended customVisionSended) {
        return service.fromUrl(customVisionSended);
    }

    @PostMapping(value = "/image")
    public CustomVisionReturned fromImage(@RequestParam("imagen") MultipartFile image) {
        return service.fromImage(image);
    }
}
