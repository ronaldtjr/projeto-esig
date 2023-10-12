import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  public login:string = ''
  public senha:string = ''
  public error:string = ''

  constructor(private router: Router, private service: AuthService){}

  logar(){
    let usuario = {
      login: this.login,
      password: this.senha
    }
    this.service.login(usuario).then(() => {
      console.log("logado")
      this.router.navigate(["home"]);
    }).catch(err => {
      console.log('erro login ' + err)
      this.error = err
    })
  }

}
