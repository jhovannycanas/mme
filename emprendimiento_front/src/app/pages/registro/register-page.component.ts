import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup,  Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'app/shared/services/auth.service';
import Swal from 'sweetalert2';

@Component({
    selector: 'app-register-page',
    templateUrl: './register-page.component.html',
    styleUrls: ['./register-page.component.scss']
})

export class RegisterPageComponent implements OnInit {

    registroForm: FormGroup;
    required = Validators.required
    roles$;

    constructor(private formBuilder: FormBuilder, private auth: AuthService,
        private router: Router) {

    }

    ngOnInit(): void {
        this.registroForm = this.formBuilder.group({
            documento: [''],
            nombre: ['', this.required],
            primerApellido: ['', this.required],
            user: ['', this.required],
            password: ['', this.required],
            segundoApellido: [''],
            fechaNacimiento: [''],
            rol: [''],
            email: [''],
        })

    this.obtenerRoles();
    }

    obtenerRoles() {
        this.auth.obtenerRoles().subscribe(
          data => {
            this.roles$ = data;
          }
        )
      }

    goLogin() {
        this.router.navigateByUrl('/login');
    }

    crearCuenta() {
        console.log(JSON.stringify(this.registroForm.value));
        this.auth.registrar(this.registroForm.value).subscribe(
            result => {
                Swal.fire(
                    'Registro exitoso!',
                    'La cuenta ha sido creada satisfactoriamente.',
                    'success'
                );
                this.goLogin();
            }
            ,
            error => {
                console.log('error', error);
                Swal.fire({
                    allowOutsideClick: false,
                    title: 'Error',
                    text: error.error.mensaje,
                    icon: 'error',
                });
            }
        );


    }
    //  On submit click, reset field value
    onSubmit() {
        //this.registerForm.reset();
    }
}
