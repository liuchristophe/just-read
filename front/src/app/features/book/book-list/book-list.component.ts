import { HttpClient } from '@angular/common/http';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { ApiService } from '../../../core/services/api.service';
import { BookModel } from '../../../core/models/books.model';
import { BookDetailsOverlayService } from 'src/app/core/services/book-details-overlay.service';

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

  detailClicked = false;

  bookSelected ?: BookModel;


  constructor(private http: HttpClient,
    private apiService: ApiService,
    private bookDetailsOverlayService: BookDetailsOverlayService) {
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
    this.bookDetailsOverlayService.update$.subscribe(updated=>{
      this.detailClicked = this.bookDetailsOverlayService.detailClicked;
    })
  }

  ngOnDestroy() {
    this.bookDetailsOverlayService.detailIsClosed();
  }

  onFilterChange(){
    console.log('onFilterChange ' + this.title);
    this.books= this.allBooks.filter(x=>this.match(x));
  }

  match(x : BookModel): boolean{
    if(this.author){
      let found = x.author?.firstname.indexOf(this.author);//TODO
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

  bookIsSelected(book: BookModel) {
    this.bookSelected = book;
    this.bookDetailsOverlayService.detailIsClicked(book.id);
  }


}