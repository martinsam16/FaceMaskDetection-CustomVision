package bean;

import client.CustomVisionClient;
import dto.CustomVisionReturned;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@RequestScoped
public class CustomVisionBean {

    @Inject
    private CustomVisionClient client;

    @Getter
    @Setter
    private String urlImagen;

    @Getter
    @Setter
    private CustomVisionReturned customVisionReturned;

    @PostConstruct
    public void init() {
        this.urlImagen = "https://estaticos.muyinteresante.es/media/cache/1000x460_thumb/uploads/images/article/5e84603a5bafe8f0d60b31d1/mujer-mascarilla-gel_0.jpg";
    }

    public void predecirUrl() throws IOException {
        this.customVisionReturned = this.client.fromUrl(this.urlImagen);
        this.containsMask();
    }

    public void containsMask() {
        String resultado = "";
        if (this.customVisionReturned.getPredictions().get(0).getProbability() >= 0.9) {
            resultado = "Con Mascarilla";
        } else {
            resultado = "Sin Mascarilla";
        }
        mostrarMensaje(resultado, "Probabilidad: " +
                this.customVisionReturned.getPredictions().get(0).getProbability().floatValue());
    }

    public void mostrarMensaje(String summary, String detail) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(summary, detail));
    }

}