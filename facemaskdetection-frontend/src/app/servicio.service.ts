import {Injectable} from '@angular/core';
import {environment} from '../environments/environment';
import {HttpClient} from '@angular/common/http';
import {CustomVisionReturned} from './model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {
  apiUrl = environment.api;

  constructor(private http: HttpClient) {
  }

  public fromUrl(urlImagen: string): Observable<CustomVisionReturned> {
    return this.http.post<CustomVisionReturned>(`${this.apiUrl}/url`, {
      Url: urlImagen
    });
  }

  public fromImage(imagen: File): Observable<CustomVisionReturned> {
    const formData = new FormData();
    formData.append('imagen', imagen);
    return this.http.post<CustomVisionReturned>(`${this.apiUrl}/image`, formData);
  }
}
