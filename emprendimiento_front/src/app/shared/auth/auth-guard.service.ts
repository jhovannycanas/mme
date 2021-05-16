import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';

@Injectable()
export class AuthGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {

    if (this.authService.isAuthenticated()) {
     const expira = Number(localStorage.getItem('expira'));
      const expiraDate = new Date();
      expiraDate.setTime(expira);
      if(expiraDate > new Date()){
        return true;
      }else{
        localStorage.removeItem('expira');
        this.router.navigateByUrl('login');
        return false
      } 
      //return true;
    } else {
      this.router.navigateByUrl('login');
      return false;
    }
  }
}

