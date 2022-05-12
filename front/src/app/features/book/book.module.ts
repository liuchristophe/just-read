import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { BookComponent } from './book.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookSliderComponent } from './book-slider/book-slider.component';
import { BookItemComponent } from './book-item/book-item.component';

@NgModule({
  declarations: [
    BookComponent,
    BookListComponent,
    BookDetailsComponent,
    BookSliderComponent,
    BookItemComponent
  ],
  imports: [
    CommonModule
  ],
  exports: [
    BookListComponent,
    BookDetailsComponent
  ]
})
export class BookModule { }
