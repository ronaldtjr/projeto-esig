import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TarefaService } from 'src/app/service/tarefa.service';
import { PRIORIDADE,  SITUACAO } from 'src/app/util/values';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit{
  public responsaveis = {}
  public titulo = ''
  public descricao = ''
  public responsavel : any;
  public newSit: any = 0;
  public newResp: any = undefined;
  public newPrior: any = undefined;
  public situacao = SITUACAO;
  public prioridade = PRIORIDADE;
  public deadline = new Date();
  public editAtual: any = undefined;

  ngOnInit(): void {
    this.http.get("http://localhost:8080/api/responsavel").subscribe(response=>{
      this.responsavel = response
    
    
    this.activatedRouter.paramMap.subscribe(param => {

      
      param.get('id')
      if(param.get('id')){
      this.service.find(parseInt(param.get('id'))).subscribe(resp=>{
        this.titulo = resp.titulo
        this.descricao = resp.descricao
        this.newPrior = this.prioridade.findIndex(obj=>obj.chave==resp.prioridade)
        this.deadline = resp.deadline
        this.newResp = resp.responsavel.id
      
        
      })
    }
      
      this.titulo
      this.descricao

      this.newSit 
      this.newResp 
      this.newPrior 
      this.deadline 
      
      this.editAtual = param.get("id")
      console.log(this.editAtual?this.editAtual:undefined);
      
    })
  })
  }

  constructor(private activatedRouter: ActivatedRoute, private route: Router, private service: TarefaService, private http:HttpClient) {
    
    
  }
  cadastrar(): void {
    
    let novo = {
      id: this.editAtual?this.editAtual:undefined,
      titulo: this.titulo,
      descricao: this.descricao,
      responsavel: this.responsavel[this.newResp-1],
      prioridade: this.prioridade[this.newPrior-1].chave,
      situacao: this.situacao[this.newSit].chave,
      deadline: this.deadline
    }
    console.log(this.newResp);
    console.log(this.situacao[0]);
    
    

    
    if(this.editAtual){
      
      
      this.service.editar(novo, this.editAtual).subscribe(() => {
        this.route.navigate(['home']);
      });
    }
    else {
     
      this.service.cadastrar(novo).subscribe(() => {
        this.route.navigate(['home']);
      });
    }
    
  }

}
