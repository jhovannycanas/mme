import { Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {
  token: string;

  constructor() {}

  signupUser(email: string, password: string) {
    //your code for signing up the new user
  }

  signinUser(email: string, password: string) {
    //your code for checking credentials and getting tokens for for signing in user
  }

  logout() {   
    this.token = null;
  }

  getToken() {
    return localStorage.getItem('documentoUsuario');
  }

  isAuthenticated() {
    console.log(this.getToken());
    return !!this.getToken();
  }
}
