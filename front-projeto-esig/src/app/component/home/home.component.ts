import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TarefaService } from 'src/app/service/tarefa.service';
import { MOCKDS, RESPONSAVEL, SITUACAO } from 'src/app/util/values';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  public filtro = {
    numero: '',
    titulo: '',
    responsavel: '',
    situacao: {id:'',valor: '',chave:''}
  };

  public displayedColumns: string[] = [
    'numero',
    'titulo',
    'responsavel',
    'acoes'
  ];

  public dataSource: any = undefined;
  public situacao = SITUACAO;
  public responsavel: any = undefined;

  constructor(private router: Router, private service: TarefaService, private http: HttpClient ) {
    this.loadData();
    console.log(this.responsavel)
  }

  loadData(): void {
    // carrega dados do backend 
    // TODO
    this.service.findAll().subscribe(resposta => {
      this.dataSource = resposta
    });

    this.http.get("http://localhost:8080/api/responsavel").subscribe(response=>{
      this.responsavel = response
    
    })

    if(this.dataSource == undefined)
      this.dataSource = MOCKDS;
  }

  editar(numero: number):void {
    this.router.navigate([`cadastro/${numero}`]);
  }

  excluir(numero: number): void { 
    // enviar delete para api
    // TODO
    this.service.excluir(numero).subscribe(()=>{},resposta => {
      console.log('deletei');
      
      this.service.findAll().subscribe(resposta => {
        this.dataSource = resposta
      });
    });
  }

  criar():void {
    this.router.navigate(['cadastro']);
  }

  concluir(novo: any):void { 
    // enviar put para api
    // TODO
    this.service.concluir(novo.id, novo).subscribe(()=>{this.service.findAll().subscribe(resposta => {
      this.dataSource = resposta
    });})
  }

  buscar() {
    
    this.filtro;
  
    console.log(this.filtro);
    
    let novoFiltro={
      id: this.filtro.numero,
      titulo: this.filtro.titulo,
      responsavel: this.filtro.responsavel,
      situacao: parseInt(this.filtro.situacao.id)-1



       
    }
    this.service.filtrar(novoFiltro).subscribe(resposta => {
      this.dataSource = resposta;

    })
  }
}
