import { Component, Input, OnInit, OnDestroy, Inject } from '@angular/core';
import { BookModel } from 'src/app/core/models/books.model';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatDialog } from '@angular/material/dialog';
import { BuyDialogComponent } from '../../buy-dialog/buy-dialog.component';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})

export class BookDetailsComponent implements OnInit, OnDestroy {
  book?: BookModel;
  book_id: any;

  constructor(   
    //  private route:ActivatedRoute,
    //  private http: HttpClient,
    //  private bookDetailsOverlayService : BookDetailsOverlayService
    public dialogRef: MatDialogRef<BookDetailsComponent>,
    @Inject(MAT_DIALOG_DATA) public data: { book: BookModel },
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.book = this.data.book;
    this.book_id = this.book.id;
    // this.loadBook();
    // this.bookDetailsOverlayService.update$.subscribe(updated=>{
    //   console.log(`detail called`);
    //   if (this.bookDetailsOverlayService.book_id != undefined) {
    //     console.log(`detail called`);
    //     this.getBookById$(this.bookDetailsOverlayService.book_id).subscribe(book => {
    //       this.book = book;
    //     });
    //   }
    // })
  }

  ngOnDestroy() {
    // this.bookDetailsOverlayService.detailIsClosed();
  }

  // loadBook(){
  //   const book_Id = this.route.snapshot.paramMap.get('id');
  //   console.log(this.book_id);
  //   this.getBookById$(this.book_id)
  //   .subscribe(
  //     data => this.book = data,
  //   )
  // }

  // getBookById$(book_id: string): Observable<BookModel> {
  //   let url = `api/books/${book_id}`;
  //   return this.http.get<BookModel>(url);
  // }

  // close() {
  //   this.bookDetailsOverlayService.detailIsClosed();
  // }

  onNoClick(): void {
    this.dialogRef.close();
  }

  openDialogPurchage() {
    this.onNoClick();

    const dialogRef = this.dialog.open(BuyDialogComponent, {
      width: '500px',
      height: '500px',
      data: { book: this.book },
    });

    dialogRef.afterClosed().subscribe();
  }


}
