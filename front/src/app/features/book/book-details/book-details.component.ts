import { Component, Input, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Overlay } from '@angular/cdk/overlay';
import { BookListComponent } from '../book-list/book-list.component';
import { ComponentPortal } from '@angular/cdk/portal';
import { BookSliderComponent } from '../book-slider/book-slider.component';
import { BookDetailsOverlayService } from 'src/app/core/services/book-details-overlay.service';
import { BookModel } from 'src/app/core/models/books.model';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})

export class BookDetailsComponent implements OnInit, OnDestroy {
  book?: BookModel;
  book_id: any;

  constructor(   
     private route:ActivatedRoute,
     private http: HttpClient,
     private bookDetailsOverlayService : BookDetailsOverlayService) {
   }

  ngOnInit(): void {
    // this.loadBook();
    this.bookDetailsOverlayService.update$.subscribe(updated=>{
      console.log(`detail called`);
      if (this.bookDetailsOverlayService.book_id != undefined) {
        console.log(`detail called`);
        this.getBookById$(this.bookDetailsOverlayService.book_id).subscribe(book => {
          this.book = book;
        });
      }
    })
  }

  ngOnDestroy() {
    this.bookDetailsOverlayService.detailIsClosed();
  }

  // loadBook(){
  //   const book_Id = this.route.snapshot.paramMap.get('id');
  //   console.log(this.book_id);
  //   this.getBookById$(this.book_id)
  //   .subscribe(
  //     data => this.book = data,
  //   )
  // }

  getBookById$(book_id: string): Observable<BookModel> {
    let url = `api/books/${book_id}`;
    return this.http.get<BookModel>(url);
  }

  close() {
    this.bookDetailsOverlayService.detailIsClosed();
  }
}
