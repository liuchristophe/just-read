import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookComponent } from './book.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookSliderComponent } from './book-slider/book-slider.component';
import { BookItemComponent } from './book-item/book-item.component';
import { BookCardComponent } from './book-card/book-card.component';


@NgModule({
  declarations: [
    BookComponent,
    BookListComponent,
    BookDetailsComponent,
    BookSliderComponent,
    BookItemComponent,
    BookCardComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    BookListComponent,
    BookDetailsComponent,
    BookSliderComponent,
    BookItemComponent
  ]
})
export class BookModule { }
