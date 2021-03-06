import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class UnauthGuardService implements CanActivate {

  constructor(private authService: AuthService, private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot) {
    
    if (!this.authService.isAuthenticated()) {
      return true;
    } else {
      this.router.navigateByUrl('dashboard');
      return false;
    }
  }
}
