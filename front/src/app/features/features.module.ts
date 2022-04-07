import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormAjoutLivreComponent } from './form-ajout-livre/form-ajout-livre.component';
import { BookListComponent } from './book-list/book-list.component';
import { BookFeatureComponent } from './book-feature/book-feature.component';



@NgModule({
  declarations: [
    FormAjoutLivreComponent,
    BookListComponent,
    BookFeatureComponent
  ],
  imports: [
    CommonModule
  ],
  exports:[
    FormAjoutLivreComponent
  ]
})
export class FeaturesModule { }
