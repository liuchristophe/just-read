import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BookModule } from './book/book.module';

import { LibraryPresentationComponent } from './library-presentation/library-presentation.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { OverlayLocationModule } from './overlay-location/overlay-location.module';

@NgModule({
  declarations: [
    LibraryPresentationComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    BookModule,
    DashboardModule,
    OverlayLocationModule

  ],
  exports:[
    LibraryPresentationComponent,
    BookModule,
    OverlayLocationModule
    
  ]
})
export class FeaturesModule { }
