import { Component, ViewChild } from '@angular/core';
import { NgForm, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from "@angular/router";
import { FormBuilder, FormGroup, FormControl} from '@angular/forms'
import { AuthService } from '../../shared/services/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  loginForm: FormGroup;
  submitted: boolean = false;
  recordar: boolean = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private formBuilder: FormBuilder,
              private auth: AuthService,
              ) { }


  ngOnInit() {
      this.loginForm = this.formBuilder.group({
        user: ['', Validators.required],
        password: ['', Validators.required]
      });

      if(localStorage.getItem('username')){
        this.f.username.setValue(localStorage.getItem('username'));
        this.recordar = true
      }
  }

  imprimeError(error) {

    Swal.fire({
      title: 'Error!',
      text: error,
      icon: 'error',
    })
  }

  get f(){
    return this.loginForm.controls;
  }

  submit(){
    this.submitted = true;
    console.log("validando");
    this.auth.login(this.loginForm.value).subscribe(
      resp => {
        if(this.recordar){
          localStorage.setItem('username', this.f.user.value)
        }
        console.log("redireccionando");
        this.router.navigateByUrl('/dashboard')
      }, (err) => {
        if (err.error == 'access denied for security reasons Usuario desabilitado, pongase en contacto con el administrador') {
          this.imprimeError('Usuario desabilitado, pongase en contacto con el administrador');
          return;
        }

        //if(err.error == 'Problems with Request Authorization Credentials Invalid credentials') 
        this.imprimeError('Usuario o contraseña invalidos, por favor verifica la información')
      }
    )
      
    
/*
    if (err.error === 'Usuario desabilitado, pongase en contacto con el administrador') {
     
    }
    */
  }

  // On submit button click
  // onSubmit() {
  //     this.loginForm.reset();
  // }

  
  // On Forgot password link click
  // onForgotPassword() {
  //     this.router.navigate(['forgotpassword'], { relativeTo: this.route.parent });
  // }
  // // On registration link click
  // onRegister() {
  //     this.router.navigate(['register'], { relativeTo: this.route.parent });
  // }

}
