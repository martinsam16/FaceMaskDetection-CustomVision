import {Component, OnInit} from '@angular/core';
import {CustomVisionReturned, Imagen} from './model';
import {ServicioService} from './servicio.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'facemaskdetection-frontend';
  public urlImagen: string;
  public imagen: Imagen = new Imagen();
  public prediccionImagen: CustomVisionReturned = new CustomVisionReturned();
  public prediccionUrl: CustomVisionReturned = new CustomVisionReturned();

  constructor(
    private cliente: ServicioService
  ) {
  }

  ngOnInit(): void {
  }

  predecirUrl(): void {
    this.cliente.fromUrl(this.urlImagen).subscribe(data => {
      this.prediccionUrl = data;
      console.log(data);
    });
  }

  predecirImagen(): void {
    this.cliente.fromImage(this.imagen.file).subscribe(data => {
      this.prediccionImagen = data;
      console.log(data);
    });
  }

  processFile(imageInput: any): void {
    const reader = new FileReader();
    this.imagen.file = imageInput.files[0];

    reader.addEventListener('load', (event: any) => {
      this.imagen.src = event.target.result;
    });
    reader.readAsDataURL(this.imagen.file);
  }

}
