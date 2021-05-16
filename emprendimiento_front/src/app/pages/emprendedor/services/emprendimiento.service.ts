import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmprendimientoService {

  readonly root_url = environment.baseURL_EMPRENDIMIENTO;
  
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Headers': 'Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization'
    })
  };

  constructor(private http: HttpClient) { }

  createEmprendimiento(data): Observable<any>{
    return this.http.post(`${this.root_url}/`, data)
  }

  getEmprendimientoByUsuario(documento): Observable<any>{
    return this.http.get(`${this.root_url}/${documento}`)
  }

  actualizarEmprendimienot(id: number, data: any): Observable<any> {
    return this.http.put<void>(`${this.root_url}/${id}`, data);
  }

  obtenerEmprendimientoById(id: number): Observable<any> {
    return this.http.get<any>(`${this.root_url}/emprendimientos/${id}`);
  }

  eliminarEmprendimiento(id:number): Observable<void> {
    return this.http.delete<void>(`${this.root_url}/${id}`);
  }

  obtenerEmprendimientos(): Observable<any> {
    return this.http.get<any>(`${this.root_url}/emprendimientos/`);
  }
}
