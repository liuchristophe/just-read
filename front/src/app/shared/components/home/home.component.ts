import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/core/services/api.service';

import { BookModel } from 'src/app/core/models/books.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private apiService: ApiService) { }

  trending1 = 'Science fiction';
  trending2 = 'Les plus populaires';

  trending3 = 'Aventure';
  booksAventure : Array<BookModel> = [];

  ngOnInit(): void {
    this.apiService.getBooksByCategoryName("Aventure").subscribe((data) => {
      this.booksAventure = data;
    }, error => {
      alert(`N'arrive pas à récupérer le getAllBooksByCategory ...`);
    });
  }

}