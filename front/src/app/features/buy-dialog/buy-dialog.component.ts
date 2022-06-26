import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BookModel } from 'src/app/core/models/books.model';

@Component({
  selector: 'app-buy-dialog',
  templateUrl: './buy-dialog.component.html',
  styleUrls: ['./buy-dialog.component.scss']
})
export class BuyDialogComponent implements OnInit {
  book?: BookModel;

  constructor(public dialogRef: MatDialogRef<BuyDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: BookModel) { }

  ngOnInit(): void {
    this.book = this.data;
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
