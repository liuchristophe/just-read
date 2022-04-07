import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-ajout-livre',
  templateUrl: './form-ajout-livre.component.html',
  styleUrls: ['./form-ajout-livre.component.scss']
})
export class FormAjoutLivreComponent implements OnInit {

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  onClickTestHttp(){
    console.log('test');
    this.httpClient.get('localhost:8080/books').subscribe(response=>{
      console.log('ok',response);
    }, error=>{
      console.log('error',error);
    });
  }
}