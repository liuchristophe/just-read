import { Component, Input, OnInit } from '@angular/core';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';
import { BookDetailsOverlayService } from 'src/app/core/services/book-details-overlay.service';



@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.scss']
})
export class BookItemComponent implements OnInit {
  @Input() book!: BookModel;

  constructor(private bookDetailsOverlayService : BookDetailsOverlayService) { }

  ngOnInit(): void {
  }

  detailIsClicked(book: BookModel) {
    // this.detailClicked = !this.detailClicked;
    console.log(`item`);
    this.bookDetailsOverlayService.detailIsClicked(book.id);
  }

}
