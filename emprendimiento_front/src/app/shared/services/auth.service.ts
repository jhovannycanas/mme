import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UsuarioModel } from '../models/usuario.model';

import { map } from 'rxjs/operators'
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = environment.baseURL;

private httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Accept': 'application/json',
    'Access-Control-Allow-Origin': '*',
    'Access-Control-Allow-Headers': 'Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization'
  })
};
  code: any;
  usuario= '';

  constructor(private http: HttpClient) { 

  }


  logout() {
    localStorage.removeItem('documentoUsuario');
    localStorage.removeItem('nombre');
  }


  obtenerRoles():Observable <any> {
    return this.http.get(`${this.url}/roles`)
  }
  login(usuario: UsuarioModel){
    const authData ={
      ...usuario,
    };

    return this.http.post(
      //`${this.url}generarToken?username=${authData.username}&password=${authData.password}&`,
      `${this.url}/login`, authData
    ).pipe(
      map( resp =>{
        this.guardarRespuesta(resp);
        return resp;
      })
    );

  }

  registrar(data) :Observable <any>{
    return this.http.post(this.url, data);
  }


  private guardarRespuesta(respuesta){
    console.log(respuesta);
    this.usuario = respuesta.nombre;
    localStorage.setItem('documentoUsuario', respuesta.documentoUsuario)
    localStorage.setItem('nombre', respuesta.nombre)
    localStorage.setItem('rol', respuesta.rol[0])


    let hoy = new Date();
    hoy.setSeconds(600)
    localStorage.setItem('expira', hoy.getTime().toString());

  }


  estaAutenticado(): boolean {

    if( this.usuario.length < 1){
      return false;
    }
    const expira = Number(localStorage.getItem('expira'));
    const expiraDate = new Date();
    expiraDate.setTime(expira);

    if(expiraDate > new Date()){
      return true;
    }else{
      return false
    }
  }

}
