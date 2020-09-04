import {Component, OnInit} from '@angular/core';
import {CustomVisionReturned} from './model';
import {ServicioService} from './servicio.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'facemaskdetection-frontend';
  public urlImagen: string;
  public modelo: CustomVisionReturned = new CustomVisionReturned();

  constructor(
    private cliente: ServicioService
  ) {
    this.urlImagen = 'https://ep01.epimg.net/elpais/imagenes/2020/05/14/buenavida/1589434606_801429_1589434806_noticia_normal.jpg';
  }

  ngOnInit(): void {
  }

  predecirUrl(): void {
    this.clear();
    this.cliente.fromUrl(this.urlImagen).subscribe(data => {
      this.modelo = data;
      console.log(data);
    });
  }

  clear(): void {
    this.modelo = new CustomVisionReturned();
  }
}
