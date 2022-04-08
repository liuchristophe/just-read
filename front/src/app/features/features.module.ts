import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormAjoutLivreComponent } from './form-ajout-livre/form-ajout-livre.component';
import { BookListComponent } from './book-list/book-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    FormAjoutLivreComponent,
    BookListComponent,
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports:[
    FormAjoutLivreComponent
  ]
})
export class FeaturesModule { }
