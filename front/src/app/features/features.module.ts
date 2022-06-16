import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookModule } from './book/book.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LibraryPresentationComponent } from './library-presentation/library-presentation.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { FormAjoutLivreComponent } from './dashboard/form-ajout-livre/form-ajout-livre.component';

@NgModule({
  declarations: [
    LibraryPresentationComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    BookModule,
    // DashboardModule
  ],
  exports:[
    LibraryPresentationComponent,
    BookModule
  ]
})
export class FeaturesModule { }
