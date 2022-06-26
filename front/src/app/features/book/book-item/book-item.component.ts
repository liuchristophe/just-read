import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';
import { BookDetailsOverlayService } from 'src/app/core/services/book-details-overlay.service';
import { BuyDialogComponent } from '../../buy-dialog/buy-dialog.component';



@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.scss']
})
export class BookItemComponent implements OnInit {
  @Input() book!: BookModel;

  constructor(private bookDetailsOverlayService : BookDetailsOverlayService,
    public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  detailIsClicked(book: BookModel) {
    // this.detailClicked = !this.detailClicked;
    console.log(`item`);
    this.bookDetailsOverlayService.detailIsClicked(book.id);
  }

  openDialog() {
    const dialogRef = this.dialog.open(BuyDialogComponent, {
      width: '500px',
      height: '250px',
      data: { book: this.book },
    });

    dialogRef.afterClosed().subscribe();
  }
}
