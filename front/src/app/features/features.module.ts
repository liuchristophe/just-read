import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { FormAjoutLivreComponent } from './form-ajout-livre/form-ajout-livre.component';
import { BookModule } from './book/book.module';
import { LibraryPresentationComponent } from './library-presentation/library-presentation.component';

@NgModule({
  declarations: [
    FormAjoutLivreComponent,
    LibraryPresentationComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    BookModule
  ],
  exports:[
    FormAjoutLivreComponent,
    LibraryPresentationComponent,
    BookModule
  ]
})
export class FeaturesModule { }
