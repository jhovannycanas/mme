import { Component, OnInit, ViewChild } from '@angular/core';
import { DatatableComponent } from '@swimlane/ngx-datatable';
import Swal from 'sweetalert2';
import { EmprendimientoService } from '../services/emprendimiento.service';

@Component({
  selector: 'app-gestion',
  templateUrl: './gestion.component.html',
  styleUrls: ['./gestion.component.scss']
})
export class GestionComponent implements OnInit {

  @ViewChild(DatatableComponent) table: DatatableComponent;
  emprendimiento$;
  rows = [];
  columns = [{name: 'id'},{name: 'nombre'},{name: 'descripcion'}, {name: 'estado'}];
  temp = [];
  
  constructor(private emprendimientoService: EmprendimientoService) { }

  ngOnInit(): void {
    console.log(localStorage.getItem('documentoUsuario'));
    this.emprendimientoService.getEmprendimientoByUsuario(localStorage.getItem('documentoUsuario'))
    .subscribe(
      data => {
        console.log(data);
        this.emprendimiento$ = data;
        this.temp = data;
        this.rows = data;
      },
      error => {}
    );

  }

  updateFilter(event) {
    //this.piarescolarItem = null;
    const val = event.target.value.toLowerCase();

    // filter our data
    const temp = this.temp.filter(function (d) {
        return d.nombre.toString().toLowerCase().indexOf(val) !== -1 || !val;
    });

    // update the rows
    this.rows = temp;
    // Whenever the filter changes, always go back to the first page
    this.table.offset = 0;
}

eliminarEmprendimiento(idEmprendimiento) {
  Swal.fire({
    title: 'Esta seguro de eliminar el registro?',
    text: "Si elimina el registro, se desactivara toda la información relacionada!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    cancelButtonText: 'No, cancelar!',
    confirmButtonText: 'Si, estoy seguro!'
  }).then((result) => {
    if (result.value) {
      this.emprendimientoService.eliminarEmprendimiento(idEmprendimiento).subscribe(
      data => {
        this.emprendimientoService.getEmprendimientoByUsuario(localStorage.getItem('documentoUsuario'))
        .subscribe(data => {
          console.log(data);
          this.emprendimiento$ = data;
          this.rows = data;
        }, error => {
          console.log(error);
        }
        );
        Swal.fire(
          'Eliminado!',
          'El registro ha sido eliminado.',
          'success'
        )
      }, error => {
        console.log(error);
        Swal.fire({
          allowOutsideClick: false,
          title: 'Error',
          text: "Ocurrio un error eliminando el registro",
          icon: 'error',
          });
      }
    );
    }
  })
}
}
