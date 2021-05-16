import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardEmprendimientoService implements CanActivate{

  constructor(private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot) {
    let rol = localStorage.getItem('rol');
    if (rol === "Emprendedor") {
      return true;
    } else {
      this.router.navigateByUrl('dashboard');
      return false;
    }
  }
}
