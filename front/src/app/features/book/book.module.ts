import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookComponent } from './book.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookSliderComponent } from './book-slider/book-slider.component';
import { BookItemComponent } from './book-item/book-item.component';
import { CarouselModule } from 'ngx-owl-carousel-o';

@NgModule({
  declarations: [
    BookComponent,
    BookListComponent,
    BookDetailsComponent,
    BookSliderComponent,
    BookItemComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    CarouselModule
  ],
  exports: [
    BookListComponent,
    BookDetailsComponent,
    BookSliderComponent,
    BookItemComponent
  ]
})
export class BookModule { }
