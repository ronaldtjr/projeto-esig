import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<any>{
    return this.http.get("http://localhost:8080/api/tarefa");
  }

  find(id): Observable<any>{
    return this.http.get(`http://localhost:8080/api/tarefa/${id}`);
  }

  editar(novo: any, id): Observable<any>{
    return this.http.put(`http://localhost:8080/api/tarefa/${id}`, novo);
  }
  cadastrar(novo: any): Observable<any>{
    return this.http.post("http://localhost:8080/api/tarefa", novo)
  }
  excluir(id): Observable<any>{
    return this.http.delete(`http://localhost:8080/api/tarefa/${id}`);
  }
  concluir(id, novo): Observable<any>{
    novo.situacao = 'CONCLUIDO'
    return this.http.put(`http://localhost:8080/api/tarefa/concluir/${id}`, novo);
   

    
  }

  filtrar(filtro): Observable<any> {
    return this.http.post("http://localhost:8080/api/tarefa/filtrar", filtro)
  }
}
