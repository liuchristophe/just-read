import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';

import { BookModule } from './book/book.module';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LibraryPresentationComponent } from './library-presentation/library-presentation.component';
import { DashboardModule } from './dashboard/dashboard.module';
import { BuyDialogComponent } from './buy-dialog/buy-dialog.component';
import { OverlayLocationModule } from './overlay-location/overlay-location.module';
import { MatIconModule } from '@angular/material/icon';
import { FormLibraryCreationComponent } from './form-library-creation/form-library-creation.component';
import { AdminPanelDialogComponent } from './admin-panel-dialog/admin-panel-dialog.component';

@NgModule({
  declarations: [
    LibraryPresentationComponent,
    BuyDialogComponent,
    FormLibraryCreationComponent,
    AdminPanelDialogComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatDialogModule,
    BookModule,
    DashboardModule,
    OverlayLocationModule,
    MatIconModule
  ],
  exports:[
    LibraryPresentationComponent,
    BookModule,
    OverlayLocationModule
    
  ]
})
export class FeaturesModule { }
