import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { FormAjoutLivreComponent } from './dashboard/form-ajout-livre/form-ajout-livre.component';
import { BookModule } from './book/book.module';


import { DashboardModule } from './dashboard/dashboard.module';
import { LibraryPresentationComponent } from './library-presentation/library-presentation.component';

@NgModule({
  declarations: [
    FormAjoutLivreComponent,
    LibraryPresentationComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    BookModule,
    DashboardModule
  ],
  exports:[
    FormAjoutLivreComponent,
    LibraryPresentationComponent,
    BookModule
  ]
})
export class FeaturesModule { }
