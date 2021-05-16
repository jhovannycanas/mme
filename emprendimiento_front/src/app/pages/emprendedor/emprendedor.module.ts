import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';
import { EmprendedorRoutingModule } from './emprendedor.routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { AutocompleteLibModule } from 'angular-ng-autocomplete';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { NgxDatatableModule } from '@swimlane/ngx-datatable';
import { RegistroComponent } from './registro/registro.component';
import { GestionComponent } from './gestion/gestion.component';
import { ActualizarComponent } from './actualizar/actualizar.component';

@NgModule({
    declarations: [RegistroComponent, GestionComponent, ActualizarComponent],
    imports: [
      CommonModule,
      EmprendedorRoutingModule,
      HttpClientModule,
      ReactiveFormsModule,
      AutocompleteLibModule,
      NgbModule,
      MatCheckboxModule,
      NgxDatatableModule
  
    ],
    providers: [
      DatePipe
    ]
  })
export class EmprendedorModule { }