import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BookItemModel } from 'src/app/core/models/book-item.model';
import { BookModel } from 'src/app/core/models/books.model';
import { ApiService } from 'src/app/core/services/api.service';
import { BookDetailsOverlayService } from 'src/app/core/services/book-details-overlay.service';
import { BuyDialogComponent } from '../../buy-dialog/buy-dialog.component';
import { BookDetailsComponent } from '../book-details/book-details.component';



@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.scss']
})
export class BookItemComponent implements OnInit {
  @Input() book!: BookModel;

  constructor(private bookDetailsOverlayService : BookDetailsOverlayService,
    private apiService: ApiService,
    public dialog: MatDialog) { }

  idLibrary = '3b3b3d57-6f2d-4dd9-a374-d7e35b761ad0';

  
  ngOnInit(): void {
  }

  detailIsClicked(book: BookModel) {
    // this.detailClicked = !this.detailClicked;
    console.log(`item`);
    this.bookDetailsOverlayService.detailIsClicked(book.id);
  }

  openDialogPurchage() {
    const dialogRef = this.dialog.open(BuyDialogComponent, {
      width: '500px',
      height: '500px',
      data: { book: this.book },
    });

    dialogRef.afterClosed().subscribe();
  }

  openDialogBookDetails(){
    const dialogRef = this.dialog.open(BookDetailsComponent, {
      width: '1000px',
      height: '1000px',
      data: { book: this.book },
    });

    dialogRef.afterClosed().subscribe();
  }
  
}
