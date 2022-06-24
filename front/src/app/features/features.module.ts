import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';

import { BookModule } from './book/book.module';
import { LibraryPresentationComponent } from './library-presentation/library-presentation.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { BuyDialogComponent } from './buy-dialog/buy-dialog.component';

@NgModule({
  declarations: [
    LibraryPresentationComponent,
    BuyDialogComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatDialogModule,
    BookModule,
    DashboardModule
  ],
  exports:[
    LibraryPresentationComponent,
    BookModule
  ]
})
export class FeaturesModule { }
