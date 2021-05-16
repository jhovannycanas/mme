import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { EmprendimientoService } from '../services/emprendimiento.service';

@Component({
  selector: 'app-actualizar',
  templateUrl: './actualizar.component.html',
  styleUrls: ['./actualizar.component.scss']
})
export class ActualizarComponent implements OnInit {

  emprendimientoForm: FormGroup;
  emprendimiento$;
  idEmprendimiento: any;

  constructor(private route: ActivatedRoute,private formBuilder: FormBuilder, private router: Router,
    private emprendimientoService: EmprendimientoService ) { }
  ngOnInit(): void {

    this.emprendimientoForm = this.formBuilder.group({
      titulo: ["", [Validators.required]],
      descripcion: ["", Validators.required],
      documentoUsuario: [""]
    })

    this.idEmprendimiento = + this.route.snapshot.paramMap.get('id');

  this.emprendimientoService.obtenerEmprendimientoById(this.idEmprendimiento).subscribe(
    data => {
      this.emprendimiento$ = data;
      this.emprendimientoForm.get('titulo').setValue(this.emprendimiento$.nombre);
      this.emprendimientoForm.get('descripcion').setValue(this.emprendimiento$.descripcion);

    }, error => {
      console.log(error);
      this.error();
    }
  )


  }

  get f() {
    return this.emprendimientoForm.controls;
  }

  error(): void {
    this.router.navigate(['/pages/emprendedor/error']);
  }

  regresar(): void {
    this.router.navigate(['/emprendedor/gestion']);
  }

  guardar() {
    if (this.emprendimientoForm.status === "VALID") {
      console.log(this.emprendimientoForm.value);

    console.log(this.emprendimientoForm.value);
    this.emprendimientoService.actualizarEmprendimienot(this.idEmprendimiento, this.emprendimientoForm.value).subscribe(
      data => {
        Swal.fire(
          'Actualizado!',
          'El registro del emprendimiento ha sido actualizado.',
          'success'
        )
      }, error => {
        console.log(error);
        Swal.fire({
          allowOutsideClick: false,
          title: 'Error',
          text: "Ocurrio un error actualizando el registro: " + error.error,
          icon: 'error',
          });
      }
    );

    } else {
        Swal.fire({
          title: 'Error!',
          text: 'Faltan campos por diligeciar',
          icon: 'error',
        })
    }
  }


}
