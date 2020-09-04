package client;

import com.google.gson.Gson;
import dto.CustomVisionReturned;
import okhttp3.*;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.Objects;

@Stateless
public class CustomVisionClient {
    private static final String URL_CUSTOM_VISION = "https://southcentralus.api.cognitive.microsoft.com/customvision/v3.0/Prediction/a26b276f-3a57-4921-82f2-b678c4b8f07a/classify/iterations/face_mask_detection_model";
    private static final String PREDICTION_KEY = "19458cc3f34343b8ada735c605165471";

    public CustomVisionReturned fromUrl(String url) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n    \"Url\":\"" + url + "\"\r\n}");
        Request request = new Request.Builder()
                .url(URL_CUSTOM_VISION + "/url")
                .method("POST", body)
                .addHeader("Prediction-Key", PREDICTION_KEY)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        return gson.fromJson(Objects.requireNonNull(response.body()).string(), CustomVisionReturned.class);
    }
}
