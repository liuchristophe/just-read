import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {
  book: any;

  constructor(   
     private route:ActivatedRoute,
     private http: HttpClient
    ) {
   }

  ngOnInit(): void {
    this.loadBook();
  }

  loadBook(){
    const bookId = this.route.snapshot.paramMap.get('id');
    console.log(bookId);
    this.getBookById$(bookId)
    .subscribe(
      data => this.book = data,
    )
  }

  getBookById$(id: string | null): Observable<any> {
    let url = `api/books/${id}`;
    return this.http.get(url);
  }

}
