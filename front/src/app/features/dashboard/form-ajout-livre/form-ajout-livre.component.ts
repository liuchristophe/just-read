import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { BookModel } from 'src/app/core/models/books.model';
import { ApiService } from '../../../core/services/api.service';

@Component({
  selector: 'app-form-ajout-livre',
  templateUrl: './form-ajout-livre.component.html',
  styleUrls: ['./form-ajout-livre.component.scss']
})
export class FormAjoutLivreComponent implements OnInit {

  pending: boolean = false;
  displayMessage: string|null = null;
  constructor(private httpClient: HttpClient, 
    private router: Router,
    private apiService: ApiService) { }

  ngOnInit(): void {
  }

  creationLivre2(data: any) {
    this.pending = true;
    this.apiService.createBook$(data).subscribe((result) => {
      console.log("livre créé",result);
      this.router.navigate(['liste_livres']);
    },error => {
      this.displayMessage='failed : error'+error.message;
      this.pending=false;
    });
  }

  creationLivre(data: any){
    let formBook: BookModel = data;
    formBook.title = data.title;
    formBook.categories = [{name : data.categories}];

    this.pending = true;
    this.httpClient.post('/api/books',formBook)
    .subscribe((result)=>{
      console.log("livre créé",result);
      this.router.navigate(['liste_livres']);
    },error=>{
      this.displayMessage='failed : error'+error.message;
      this.pending=false;
    });
    console.log(data);
  }
}