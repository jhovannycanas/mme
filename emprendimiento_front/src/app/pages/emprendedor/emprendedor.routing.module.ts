import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ActualizarComponent } from './actualizar/actualizar.component';
import { RegistroComponent } from './registro/registro.component';
import { GestionComponent } from './gestion/gestion.component';


const routes: Routes = [
  {
    path:'gestion',
    component: GestionComponent,
    data: {
      title: 'Gestion de emprendimientos'
    }
  },
  {
    path:'registro',
    component: RegistroComponent,
    data: {
      title: 'Registrar emprendimiento'
    }
  },
  {
    path: 'actualizaremprendimiento/:id',
    component: ActualizarComponent,
    data: {
      title: 'Formulario de actualización emprendimiento'
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmprendedorRoutingModule { }