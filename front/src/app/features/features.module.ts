import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { FormAjoutLivreComponent } from './form-ajout-livre/form-ajout-livre.component';
import { BookModule } from './book/book.module';

@NgModule({
  declarations: [
    FormAjoutLivreComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    BookModule
  ],
  exports:[
    FormAjoutLivreComponent,
    BookModule
  ]
})
export class FeaturesModule { }
