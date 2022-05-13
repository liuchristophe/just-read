import { Component, Input, OnInit } from '@angular/core';
import { BookItemModel } from 'src/app/core/models/book-item.model';



@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.scss']
})
export class BookItemComponent implements OnInit {
  @Input() book!: BookItemModel;

  constructor() { }

  ngOnInit(): void {
  }

}