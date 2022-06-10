import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/core/services/api.service';

import { BookModel } from 'src/app/core/models/books.model';
import { LibraryModel } from 'src/app/core/models/library.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private apiService: ApiService) { }

  trending1 = 'Science fiction';
  trending2 = 'Les plus populaires';

  trendingAventure = 'Aventure';
  booksAventure : Array<BookModel> = [];

  trendingFantasy = 'Fantasy';
  booksFantasy : Array<BookModel> = [];

  libraryProche : LibraryModel = {} as LibraryModel;

  ngOnInit(): void {
    this.apiService.getBooksByCategoryName("Aventure").subscribe((data) => {
      this.booksAventure = data;
    }, error => {
      alert(`N'arrive pas à récupérer le getAllBooksByCategory ...`);
    });

    this.apiService.getBooksByCategoryName("Fantasy").subscribe((data) => {
      this.booksFantasy = data;
    }, error => {
      alert(`N'arrive pas à récupérer le getAllBooksByCategory ...`);
    });

    this.apiService.getAllLibrary().subscribe((data) => {
      if(data.length>0) this.libraryProche = data[0];
    }, error => {
      alert(`N'arrive pas à récupérer le getAllLibrary ...`);
    });
  }

}