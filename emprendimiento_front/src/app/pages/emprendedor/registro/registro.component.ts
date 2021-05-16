import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';
import { EmprendimientoService } from '../services/emprendimiento.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent implements OnInit {

  emprendimientoForm: FormGroup;

  constructor(private route: ActivatedRoute,private formBuilder: FormBuilder, private router: Router,
    private EmprendimientoService: EmprendimientoService ) { }
  ngOnInit(): void {

    this.emprendimientoForm = this.formBuilder.group({
      titulo: ["", [Validators.required]],
      descripcion: ["", Validators.required],
      documentoUsuario: [""]
    })
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
    this.emprendimientoForm.get('documentoUsuario').setValue(localStorage.getItem('documentoUsuario'));

    console.log(this.emprendimientoForm.value);
    this.EmprendimientoService.createEmprendimiento(this.emprendimientoForm.value).subscribe(
      data => {
        Swal.fire(
          'Guardado!',
          'El registro del emprendimiento ha sido guardado.',
          'success'
        )
      }, error => {
        console.log(error);
        Swal.fire({
          allowOutsideClick: false,
          title: 'Error',
          text: "Ocurrio un error guardando el registro: " + error.error,
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
