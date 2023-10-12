import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpErrorResponse,
} from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({ providedIn: 'root' })
export class AuthInterceptor implements HttpInterceptor {
  constructor(private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    let request: HttpRequest<any> = req;

   

    if(!req.url.includes('/api/login'))
    request = req.clone({
      headers: req.headers.set('Authorization', 'Bearer ' +  sessionStorage.getItem('token'))
    });

   
    return next.handle(request).pipe(catchError(error => {
      if (error.error instanceof ErrorEvent) {
        
        console.error('Ocorreu um erro:', error.error.message);
      }
  
      if(error.error instanceof HttpErrorResponse && !request.url.includes('/api/login')){
        console.error('Ocorreu um erro: (sessão expirada) ', error.error.message);
      }
      
      sessionStorage.removeItem('token')
      alert("token de sessão expirado")
      this.router.navigate(['login'])
      return throwError(error.error);
    }));
  }
}
