import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ApiService } from '../../../core/services/api.service';
import { BookModel } from '../../../core/models/books.model';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {

  allBooks: Array<BookModel> = [];

  books: Array<BookModel> = [];

  author: string = '';

  title: string = '';


  constructor(private http: HttpClient,
    private apiService: ApiService) {
    this.init();
    
   }

  async init(){
    // // this.bookList = await this.getBookList(0,10);
    // let resp = this.http.get(`/api/books`);
    // resp.subscribe((data)=>this.books=data);
  }

  ngOnInit() {
    this.apiService.getAllBooks$().subscribe((data) => {
      this.allBooks = data;
      this.onFilterChange();
    }, error => {
      alert(`N'arrive pas à récupérer le getAllBooks ...`);
    });
}

  onFilterChange(){
    console.log('onFilterChange ' + this.title);
    this.books= this.allBooks.filter(x=>this.match(x));
  }

  match(x : BookModel): boolean{
    if(this.author){
      let found = x.author.indexOf(this.author);
      if(found ===-1){
        return false;
      }
    }
    if(this.title){
      let found = x.title.indexOf(this.title);
      if(found ===-1){
        return false;
      }
    }
    return true;
  }
}