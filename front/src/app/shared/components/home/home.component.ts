import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/core/services/api.service';

import { BookModel } from 'src/app/core/models/books.model';
import { LibraryModel } from 'src/app/core/models/library.model';
import { CacheAdresse } from 'src/app/core/services/cacheAdresse';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(
    private apiService: ApiService) { }

  trending1 = 'Science fiction';
  trending2 = 'Les plus populaires';

  trendingAventure = 'Aventure';
  booksAventure : Array<BookModel> = [];

  trendingFantasy = 'Fantasy';
  booksFantasy : Array<BookModel> = [];

  libraries : Array<LibraryModel> = []
  libraryProche : LibraryModel = {} as LibraryModel;

  getAllBookFromCategory(categoryName: string): Array<BookModel>{
    let books: Array<BookModel> = [];
    this.libraries.forEach(
      library => library.stocks.forEach(
        stock => stock.book.categories.forEach(
          category=> 
          {
            if(category.name==categoryName)  books.push(stock.book)
          }
        )
      )
    );
    return books;
  }



  ngOnInit(): void {

    this.apiService.getAllLibraryNearby$(parseFloat(localStorage.getItem("latitude") as string), parseFloat(localStorage.getItem("longitude") as string)).subscribe((data) => {

      if(data.length>0) {
        this.libraries = data;
        this.libraryProche = data[0];
        this.booksAventure=this.getAllBookFromCategory("Aventure")
        this.booksFantasy=this.getAllBookFromCategory("Fantasy")
      }else{
        this.libraryProche = {} as LibraryModel
      }
    }, error => {
      alert(`N'arrive pas à récupérer le getAllLibraryNearby ...`);
    });
  }

}
