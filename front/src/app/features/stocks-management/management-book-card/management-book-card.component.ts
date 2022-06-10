import { Component, Input, OnInit } from '@angular/core';
import { BookItemModel } from 'src/app/core/models/book-item.model';

@Component({
  selector: 'app-management-book-card',
  templateUrl: './management-book-card.component.html',
  styleUrls: ['./management-book-card.component.scss']
})
export class ManagementBookCardComponent implements OnInit {

  @Input() book?: BookItemModel;

  constructor() { }

  ngOnInit(): void {
  }

  getImage() {
    return this.book?.image;
  }

  getTitle() {
    return this.book?.title;
  }

}
