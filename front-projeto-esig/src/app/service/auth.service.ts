import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { 
  }

  public async login(user: User): Promise<boolean> {
    const result = await this.http
      .post<any>(`/api/login`, user)
      .toPromise();
    if (result && result.access_token) {
      sessionStorage.setItem('token', result.access_token);
      return true;
    }
    return false;
  }

  public getAuthorizationToken = (): string | null =>
    sessionStorage.getItem('token');

}
