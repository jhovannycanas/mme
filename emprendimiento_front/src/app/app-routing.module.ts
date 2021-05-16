import { NgModule } from '@angular/core';
import { RouterModule, Routes, PreloadAllModules } from '@angular/router';

import { FullLayoutComponent } from "./layouts/full/full-layout.component";
import { ContentLayoutComponent } from "./layouts/content/content-layout.component";

import { Full_ROUTES } from "./shared/routes/full-layout.routes";
import { CONTENT_ROUTES } from "./shared/routes/content-layout.routes";
import { LoginComponent } from './pages/login/login.component';
import { ErrorPageComponent } from './pages/error/error-page.component';
import { AuthGuard } from './shared/auth/auth-guard.service';
import { UnauthGuardService } from './shared/auth/unauth-guard.service';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';

import { RegisterPageComponent } from './pages/registro/register-page.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  },
  { path: '', component: FullLayoutComponent, data: { title: 'full Views' }, children: Full_ROUTES, canActivate: [AuthGuard] },
  { path: '', component: ContentLayoutComponent, data: { title: 'content Views' }, children: CONTENT_ROUTES, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent, data: {title: 'Inicio de sesión'}},
  { path: 'registro', component: RegisterPageComponent, data: {title: 'Crear cuenta'}},
  {path: 'error', component: ErrorPageComponent, data: {title: 'Error Page',  pathMatch: 'full'}},
  {path:  '**', component: ErrorPageComponent, data: {title: 'Error Page'}},
];


@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
