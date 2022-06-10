import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { BookModule } from './book/book.module';
import { LibraryPresentationComponent } from './library-presentation/library-presentation.component';
import { FormAjoutLivreComponent } from './dashboard/form-ajout-livre/form-ajout-livre.component';
import { DashboardModule } from './dashboard/dashboard.module';

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
